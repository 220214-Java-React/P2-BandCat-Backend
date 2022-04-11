package com.bandcat.BandCat.controller;

import com.bandcat.BandCat.model.User;
import com.bandcat.BandCat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is designed to handle requests/responses for User-based
 * tasks between the frontend and Service.
 * Spring, Spring Web, etc. contain the logic needed to
 * manage requests sent to the API and responses sent outward.
 */
@RestController

@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * A method to create a user from a http request
     * @param user
     * @author Tom and Tyler
     */
    @PostMapping
    public User createNewUser(@RequestBody User user)
    {
        return userService.createNewUser(user);  // returns user profile
    }

    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();

    }

    /**
     * A method to find a user by their User ID
     * @author Tyler
     * @param id
     */
    @GetMapping("/{id}")
    public User getByUserId(@PathVariable Integer id)
    {
        return userService.getByUserID(id); // returns user profile according to their ID number

    }

    /**
     * A method to find user information based off username
     * @author Tyler
     * @param username
     */
    @GetMapping("/byUsername/{username}")
    public User findByUsername(@PathVariable String username)
    {
        return userService.findByUsername(username); // returns a user profile based off their username
    }
}

