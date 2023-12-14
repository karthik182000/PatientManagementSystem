package org.application.controller;

import org.application.entity.Patient;
import org.application.entity.User;
import org.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/{id}/patients")
    public List<Patient> getPatientsAddedByUser(@PathVariable("id") Long userId) {
        return userService.getPatientsAddedByUser(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long userId, @RequestBody User updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
    }


}
