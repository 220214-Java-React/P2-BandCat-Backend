package com.bandcat.BandCat.service;

import com.bandcat.BandCat.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTests
{
    @LocalServerPort
    private int port;

    @Autowired
    UserService userService;

    @Test
    public void TestClassWorks()
    {
        assertTrue(true);
    }

    @Test
    @DisplayName("Test for the creation of a new User")
    public void canCreateANewUser()
    {
        User u = new User();
        u.setUsername("Username");
        assertEquals("Username", userService.createNewUser(u).getUsername());
    }
    @Test
    @DisplayName("Test to test user by Username")
    public void  findByUsername()
    {
        User u = new User();
        u.setUsername("Users");
        userService.createNewUser(u);
//        User p = userService.findByUsername(u.getUsername());
/**
 * What this is doing is confirming that it's getting the matching or correct username (.getusername()).getUsername()); */

        assertEquals("Users", userService.findByUsername(u.getUsername()).getUsername());
 }
}


