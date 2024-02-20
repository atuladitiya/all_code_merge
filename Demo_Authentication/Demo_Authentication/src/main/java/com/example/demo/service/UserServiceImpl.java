package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.demo.error.UserAlreadyExistsException;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

	@Override
	public User register(User user) throws UserAlreadyExistsException {
		Optional<User> users= userRepository.findByUsername(user.getUsername());
	       if(users.isPresent())
	           throw new UserAlreadyExistsException("User Already Exists");
	       else {
	           String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
	           user.setPassword(encryptedPassword);
	           return userRepository.save(user);

	       }
	}

	@Override
	public User login(User user) throws UserNotFoundException {
		User  userFound = null;
	      Optional<User> userLogin=  userRepository.findByUsername(user.getUsername());
	      if(userLogin.isPresent())
	      {

	          userFound =userLogin.get();
	         boolean isValid= BCrypt.checkpw(user.getPassword(),userFound.getPassword());
	          if(!isValid)
	              throw new UserNotFoundException("Login Credientials does not match");
	      }
	      return userFound;
}
}
