package com.berzanozgenc.bil344.hw2.controller;

import com.berzanozgenc.bil344.hw2.model.User;
import com.berzanozgenc.bil344.hw2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        Optional<User> returnedUser = userService.getUserById(id);
        if(returnedUser.isPresent())
            return new ResponseEntity<>(returnedUser.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }


}
