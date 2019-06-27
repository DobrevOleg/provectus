package com.dobrev.bookshop.repo;

import com.dobrev.bookshop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}
