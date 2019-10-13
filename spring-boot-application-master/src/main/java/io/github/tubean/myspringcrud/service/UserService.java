package io.github.tubean.myspringcrud.service;

import java.util.List;
import java.util.Optional;

import io.github.tubean.myspringcrud.entity.User;

public interface UserService {
  List<User> getAllUser();

  void saveUser(User user);

  void deleteUser(Long id);

  Optional<User> findUserById(Long id);
}
