package com.studyonline.service;

import com.studyonline.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();

    void saveUser(User user);

    Optional<User>findUserById(Integer id);
    User blockUser(int id);

    Page<User> findUser(Pageable pageable);

}
