package com.bandcat.BandCat.service;

import com.bandcat.BandCat.model.Instrument;
import com.bandcat.BandCat.model.InstrumentOptions;
import com.bandcat.BandCat.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

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
    UserService userService;    // Service to use

    /**
     * @author Marcus
     */
    @Test
    public void TestClassWorks()
    {
        assertTrue(true);
    }

    /**
     * @author Marcus
     */
    @Test
    @DisplayName("Test for the creation of a new User")
    public void canCreateANewUser()
    {
        User u = new User();        // Instantiate a User
        u.setUsername("Username");  // Set the username

        // Check if the username("Username") matches the username of the User returned from creation method in userService
        assertEquals("Username", userService.createNewUser(u).getUsername());
    }
    /**
     * @author Marcus
     */
    @Test
    @DisplayName("Test to get a list of all users")
    public void getAllUsers()
    {
        // List to contain original users
        List<User> listOfUsers = new ArrayList<>();

        // Assign random users to list before persisting them
        for (int i = 0; i < 5; i++)
        {
            User u = new User();
            u.setUsername("User");
            listOfUsers.add(u);
            userService.createNewUser(u);
        }

        // List of Users found from getAllUsers method
        List<User> foundUsers = userService.getAllUsers();

        // Check if the Lists match
        for (int i = 0; i < foundUsers.size(); i++)
        {
            assertEquals(listOfUsers.get(i).getUsername(), foundUsers.get(i).getUsername());
        }
    }

    /**
     * @author Elaine, Jazib, Marcus
     */
    @Test
    @DisplayName("Test to find a user by username")
    public void findAUserByUsername()
    {
        User u = new User();            // Instantiate a user
        u.setUsername("Username");      // Set the username
        userService.createNewUser(u);   // Create/persist the user

        // Check if the expected value ("Username") matches the username of the User returned from userService
        assertEquals("Username", userService.findByUsername(u.getUsername()).getUsername());
    }

    /**
     * @author Jazib
     */
    @Test
    @DisplayName("Test to find a user by user id")
    public void getByUserID()
    {
        User u = new User();            // Instantiate a user
        u.setUserID(1);      // Set the user id
        userService.createNewUser(u);   // Create/persist the user

        // Check if the expected value ("Username") matches the username of the User returned from userService
        assertEquals(1, userService.getByUserID(u.getUserID()).getUserID());
    }
}


