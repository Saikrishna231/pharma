package com.app.service;


import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    public int loginValidation(String username, String password);
}
