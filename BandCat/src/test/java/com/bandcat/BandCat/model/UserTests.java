package com.bandcat.BandCat.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * This class is designed to create Tests for User models.
 */
@SpringBootTest
public class UserTests
{
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
    public void canCreateANewUserObj()
    {
        User u = new User();

        assertNotNull(u);
    }

    /**
     * @author Elaine & Marcus
     */
    @Test
public void TestUsersFields() {

    User u = new User();
    u.setUserID(1);
    u.setUsername("Bubu");
    u.setPassword("password");
    u.setEmail("bubu@yoohoo.com");
    u.setPhoneNumber("555-555-5555");

    assertEquals(1, u.getUserID());
    assertEquals("Bubu", u.getUsername());
    assertEquals("password", u.getPassword());
    assertEquals("bubu@yoohoo.com", u.getEmail());
    assertEquals("555-555-5555", u.getPhoneNumber());



}

}
