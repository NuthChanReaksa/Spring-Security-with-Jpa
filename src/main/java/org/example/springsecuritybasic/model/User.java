package org.example.springsecuritybasic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "users_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;
    @Column(unique = true)
    private String email;
    private String password;

    private Boolean isDisabled;
    private Boolean isAccountLocked;
    private Boolean isAccountExpired;
    private Boolean isCredentialsExpired;


    @ManyToMany(fetch = FetchType.EAGER)
    Set<Role> roles;


}
