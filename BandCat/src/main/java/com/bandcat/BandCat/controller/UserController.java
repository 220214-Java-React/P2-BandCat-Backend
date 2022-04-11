package com.bandcat.BandCat.controller;

import com.bandcat.BandCat.model.User;
import com.bandcat.BandCat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

