package com.tdd.store.domain.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

  public boolean isUserMinor(Long userId) {
    return true;
  }
  
}
