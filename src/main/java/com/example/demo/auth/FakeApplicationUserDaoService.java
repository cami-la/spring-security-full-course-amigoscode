package com.example.demo.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.demo.security.ApplicationUserRole.*;

@Repository(value="fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        STUDENT.getSimpleGrantedAuthorities(),
                        "annaSmith",
                        passwordEncoder.encode("password"),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMIN.getSimpleGrantedAuthorities(),
                        "linda",
                        passwordEncoder.encode("password123"),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMINTRAINEE.getSimpleGrantedAuthorities(),
                        "tom",
                        passwordEncoder.encode("password123"),
                        true,
                        true,
                        true,
                        true
                )
        );

        return applicationUsers;
    }
}
