package com.example.demo.service;

import com.example.demo.error.UserAlreadyExistsException;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.model.User;

public interface UserService {
	public User register (User user) throws UserAlreadyExistsException;

    public User login(User user) throws UserNotFoundException;

}
