package ru.learnup.learnup.spring.mvc.homework33.repository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.learnup.learnup.spring.mvc.homework33.model.UserWithRoles;
import ru.learnup.learnup.spring.mvc.homework33.roles.UserRoleForUser;

import java.util.List;
import java.util.Map;

@Repository
public class UserWithRolesRepository {

    private final Map<String, UserWithRoles> users;
    private final BCryptPasswordEncoder encoder;

    public UserWithRolesRepository(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
        users = Map.of(
                "make", UserWithRoles.builder()
                        .login("mike")
                        .password(encoder.encode("123"))
                        .roles(List.of(new UserRoleForUser("USER")))
                        .build(),
                "user", UserWithRoles.builder()
                        .login("user")
                        .password(encoder.encode("123"))
                        .roles(List.of(new UserRoleForUser("USER")))
                        .build(),
                "admin", UserWithRoles.builder()
                        .login("admin")
                        .password(encoder.encode("123"))
                        .roles(List.of(new UserRoleForUser("USER"), new UserRoleForUser("ADMIN")))
                        .build()
        );
    }

    public UserWithRoles getUserByLogin(String login) {
            return users.get(login);
    }

}
