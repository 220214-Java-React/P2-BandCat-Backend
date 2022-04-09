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
}
