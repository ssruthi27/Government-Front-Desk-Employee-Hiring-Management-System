package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public User createUser(User user){
    return userRepository.save(user);
  }

  public List<User> getAllUsers(){
    return userRepository.findAll();
  }

  public User getUserById(Long id){
    return userRepository.findById(id).orElse(null);
  }

  public User updateUser(Long id, User user){
    Optional<User> existing = userRepository.findById(id);
    if(existing.isPresent()){
      User existingUser = existing.get();
      existingUser.setUsername(user.getUsername());
      existingUser.setEmail(user.getEmail());
      existingUser.setPassword(user.getPassword());
      existingUser.setRole(user.getRole());
      existingUser.setPhoneNumber(user.getPhoneNumber());
      existingUser.setDepartment(user.getDepartment());
      return userRepository.save(existingUser);
    }
    return null;
  }

  public void deleteUser(Long id){
    userRepository.deleteById(id);
  }

  public Page<User> getUsersWithPagination(Pageable pageable){
    return userRepository.findAll(pageable);
  }
}

