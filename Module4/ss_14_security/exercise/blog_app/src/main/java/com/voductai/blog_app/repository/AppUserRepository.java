package com.voductai.blog_app.repository;

import com.voductai.blog_app.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository< AppUser, Long> {

    AppUser findByUserName(String username);
}
