package com.findit.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.findit.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
