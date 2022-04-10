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
}
