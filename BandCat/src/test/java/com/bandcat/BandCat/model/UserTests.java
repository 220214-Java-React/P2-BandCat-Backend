package com.bandcat.BandCat.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTests
{
    @Test
    public void TestClassWorks()
    {
        assertTrue(true);
    }

    @Test
    @DisplayName("Test for the creation of a new User")
    public void canCreateANewUserObj()
    {
        User u = new User();

        assertNotNull(u);
    }


}
