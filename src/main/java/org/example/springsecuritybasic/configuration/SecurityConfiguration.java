package org.example.springsecuritybasic.configuration;


import lombok.RequiredArgsConstructor;
import org.example.springsecuritybasic.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final CustomUserDetailsService customUserDetailsService;



    @Bean
    public DaoAuthenticationProvider authProvider (UserDetailsService userDetailsService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(customUserDetailsService);
        return provider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filter (HttpSecurity http) throws Exception{
        return
                http.authorizeHttpRequests(
                        (authz) ->authz.requestMatchers("/login","/register")
                                .permitAll()
                                .requestMatchers("api/v1/articles/**").hasAnyRole("USER","ADMIN")
                                .requestMatchers("api/v1/admins/**").hasRole("ADMIN")
                        .anyRequest()
                                .authenticated())

                        .csrf(AbstractHttpConfigurer::disable)
                        .formLogin(AbstractHttpConfigurer::disable).httpBasic(Customizer.withDefaults())
                        .httpBasic(Customizer.withDefaults())
                        .build();
    }

}
/*

   @Bean
    public UserDetailsService userDetailService(){
        UserDetails user1 = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        UserDetails user2 = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

         UserDetails user3 = User.builder()
                .username("user1")
                 .password(passwordEncoder().encode("password"))
                .roles("AUTHOR")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);

    }

.requestMatchers("api/v1/admin/**").hasRole("ADMIN")
                                .requestMatchers("api/v1/authors/**").hasRole("AUTHOR")
                                .requestMatchers("api/v1/user/**").hasRole("USER")

*/