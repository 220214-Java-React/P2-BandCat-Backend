package com.bandcat.BandCat.service;

import com.bandcat.BandCat.model.Instrument;
import com.bandcat.BandCat.model.InstrumentOptions;
import com.bandcat.BandCat.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is designed to create Tests for Instrument services.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // webEnvironment creates a temporary web server port to run requests/responses through
public class InstrumentServiceTests
{

    /**
     * Marcus Glover
     */
    @LocalServerPort
    private int port;           // Port to use in webEnvironment

    /**
     * Marcus Glover
     *
     * Services to use
     */
    @Autowired
    InstrumentService instrumentService;

    @Autowired
    UserService userService;

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
    @DisplayName("Test to persist new Instruments")
    public void persistANewInstrumentWithTheInstrumentServiceClass()
    {
        User u = new User();            // Create a User to be assigned this instrument
        u.setUsername("A_User");
        u = userService.createNewUser(u);   // Create the user in database to use just for this test
        System.out.println(u.getUserID());

        // Create an Instrument w/ user that this instrument should be mapped to
        Instrument i = new Instrument(0, InstrumentOptions.CLARINET, 10, u);

        // Create/persist the Instrument
        i = instrumentService.createNewInstrument(i, u);

        // Check if the expected value matches the Instrument created
        assertEquals(InstrumentOptions.CLARINET , i.getInstrumentName());
    }
}
