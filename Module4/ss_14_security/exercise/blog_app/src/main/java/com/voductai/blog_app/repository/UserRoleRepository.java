package com.voductai.blog_app.repository;


import com.voductai.blog_app.model.user.AppUser;
import com.voductai.blog_app.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRoleRepository extends JpaRepository< UserRole, Long> {

    List<UserRole> findByAppUser(AppUser appUser);

    //Nếu sử dụng  manytomany thì cần phải thay dổi repository này thành ROLE và
    //sử dụng @Query để có thể lấu list<Role> dựa vào AppUser (người đang đăng nhập)
}
