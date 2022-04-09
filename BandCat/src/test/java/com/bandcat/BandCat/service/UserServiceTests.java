package com.bandcat.BandCat.service;

import com.bandcat.BandCat.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is designed to create Tests for User services.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // webEnvironment creates a temporary web server port to run requests/responses through
public class UserServiceTests
{
    /**
     * Marcus Glover
     */
    @LocalServerPort
    private int port;           // Port to use in webEnvironment

    /**
     * Marcus Glover
     */
    @Autowired
    UserService userService;    // Services to use

    /**
     * @author Marcus Glover
     */
    @Test
    public void TestClassWorks()
    {
        assertTrue(true);
    }

    /**
     * @author Marcus Glover
     */
    @Test
    @DisplayName("Test for the creation of a new User")
    public void canCreateANewUser()
    {
        User u = new User();
        u.setUsername("Username");
        assertEquals("Username", userService.createNewUser(u).getUsername());
    }
}
