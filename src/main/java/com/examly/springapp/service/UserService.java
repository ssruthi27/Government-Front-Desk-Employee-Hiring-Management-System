package com.examly.springapp.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.examly.springapp.model.User;

public interface UserService {
  User createUser(User user);
  List<User> getAllUsers();
  User getUserById(Long id);
  User updateUser(Long id, User user);
  void deleteUser(Long id);
  Page<User> getUsersWithPagination(Pageable pageable);
}

