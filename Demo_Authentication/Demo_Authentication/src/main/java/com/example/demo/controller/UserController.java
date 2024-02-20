package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.UserAlreadyExistsException;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.jwtUtil;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("users/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        try{
          User userRegistered=  userService.register(user);
          return new ResponseEntity<User>(userRegistered,HttpStatus.CREATED); 
        }
        catch(UserAlreadyExistsException exe){
            return new ResponseEntity<String>(exe.getMessage(), HttpStatus.CONFLICT); 
        }

    }


    @PostMapping("users/login")
    public ResponseEntity<?> loginUser (@RequestBody User user)
    {
        try{
          User userLogin=  userService.login(user); 

         Map<String,String> tokenWithMessage= jwtUtil.generateToken(userLogin.getUsername());

         return new ResponseEntity<Map<String,String>>(tokenWithMessage,HttpStatus.OK);  
        }
        catch(UserNotFoundException exe){
            return new ResponseEntity<String>(exe.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}

