package com.studyonline.repository;

import com.studyonline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findAll();
}
