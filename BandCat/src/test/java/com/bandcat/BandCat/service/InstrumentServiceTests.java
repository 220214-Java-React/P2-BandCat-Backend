package com.bandcat.BandCat.service;

import com.bandcat.BandCat.model.Instrument;
import com.bandcat.BandCat.model.InstrumentOptions;
import com.bandcat.BandCat.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

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

    /**
     * @author Marcus
     */
    @Test
    @DisplayName("Test the retrieval of all Instruments")
    public void retrieveAllInstruments()
    {
        User u = new User();            // Create a User to be assigned this instrument
        u.setUsername("User");
        User u2 = new User();            // Create a User to be assigned this instrument
        u2.setUsername("User2");
        User u3 = new User();            // Create a User to be assigned this instrument
        u3.setUsername("User3");

        u = userService.createNewUser(u);   // Create the user in database to use just for this test
        u2 = userService.createNewUser(u2);   // Create the user in database to use just for this test
        u3 = userService.createNewUser(u3);   // Create the user in database to use just for this test

        // Create an Instrument w/ user that this instrument should be mapped to
        Instrument i = new Instrument();
        i.setUser(u);
        i.setInstrumentName(InstrumentOptions.CLARINET);

        // Create an Instrument w/ user that this instrument should be mapped to
        Instrument i2 = new Instrument();
        i2.setUser(u2);
        i2.setInstrumentName(InstrumentOptions.CLARINET);

        // Create an Instrument w/ user that this instrument should be mapped to
        Instrument i3 = new Instrument();
        i3.setUser(u3);
        i3.setInstrumentName(InstrumentOptions.CLARINET);

        // Create/persist the Instrument
        instrumentService.createNewInstrument(i, u);

        // Create/persist the Instrument
        instrumentService.createNewInstrument(i2, u2);

        // Create/persist the Instrument
        instrumentService.createNewInstrument(i3, u3);

        // Get all persisted instruments
        List<Instrument> listing = instrumentService.getAllInstruments();

        // Check if it returns a list
        assertNotNull(listing);

        // Loop through instruments and check if they match the above fields
        for (int c = 0; c < listing.size(); c++)
        {
            if(c == 0)
            {
                assertEquals(u.getUsername(), listing.get(c).getUser().getUsername());
                assertEquals(InstrumentOptions.CLARINET, listing.get(c).getInstrumentName());
            }
            else if (c == 1)
            {
                assertEquals(u2.getUsername(), listing.get(c).getUser().getUsername());
                assertEquals(InstrumentOptions.CLARINET, listing.get(c).getInstrumentName());
            }
            else if (c == 2)
            {
                assertEquals(u3.getUsername(), listing.get(c).getUser().getUsername());
                assertEquals(InstrumentOptions.CLARINET, listing.get(c).getInstrumentName());
            }
        }
    }

    /**
     * @author Marcus
     */
    @Test
    public void findAnInstrumentBasedOnUserID()
    {
        User u = new User();
        u.setUsername("Username");
        u = userService.createNewUser(u);

        Instrument i = new Instrument();
        i.setUser(u);
        i.setInstrumentName(InstrumentOptions.GUITAR);

        instrumentService.createNewInstrument(i, u);

        Instrument foundInstrument = userService.findByUserID(u.getUserID()).getInstrument();

        assertEquals(u.getUsername(), foundInstrument.getUser().getUsername());
        assertEquals(InstrumentOptions.GUITAR, foundInstrument.getInstrumentName());
    }

    /**
     * @author Marcus
     */
    @Test
    @DisplayName("Test to retrieve a list of a specific instrument")
    public void findTheListOfASpecificInstrument()
    {
        User u = new User();            // Create a User to be assigned this instrument
        u.setUsername("User");
        User u2 = new User();            // Create a User to be assigned this instrument
        u2.setUsername("User2");
        User u3 = new User();            // Create a User to be assigned this instrument
        u3.setUsername("User3");

        u = userService.createNewUser(u);   // Create the user in database to use just for this test
        u2 = userService.createNewUser(u2);   // Create the user in database to use just for this test
        u3 = userService.createNewUser(u3);   // Create the user in database to use just for this test

        // Create an Instrument w/ user that this instrument should be mapped to
        Instrument i = new Instrument();
        i.setUser(u);
        i.setInstrumentName(InstrumentOptions.CLARINET);

        // Create an Instrument w/ user that this instrument should be mapped to
        Instrument i2 = new Instrument();
        i2.setUser(u2);
        i2.setInstrumentName(InstrumentOptions.CLARINET);

        // Create an Instrument w/ user that this instrument should be mapped to
        Instrument i3 = new Instrument();
        i3.setUser(u3);
        i3.setInstrumentName(InstrumentOptions.CLARINET);


        // Create/persist the Instrument
        instrumentService.createNewInstrument(i, u);

        // Create/persist the Instrument
        instrumentService.createNewInstrument(i2, u2);

        // Create/persist the Instrument
        instrumentService.createNewInstrument(i3, u3);

        // Get all persisted instruments
        List<Instrument> listing = instrumentService.findListByInstrumentName(InstrumentOptions.CLARINET);

        assertNotNull(listing);

        for (Instrument iS: listing)
        {
            System.out.println(iS.getInstrumentName());
            System.out.println(iS.getUser().getUsername());
            assertEquals(InstrumentOptions.CLARINET, iS.getInstrumentName());
        }
    }


    /**
     * @author Marcus
     */
    @Test
    @DisplayName("Test to retrieve a list of a specific instrument")
    public void findTheListOfInstrumentsBasedOnConfidence()
    {
        User u = new User();            // Create a User to be assigned this instrument
        u.setUsername("User");
        User u2 = new User();            // Create a User to be assigned this instrument
        u2.setUsername("User2");
        User u3 = new User();            // Create a User to be assigned this instrument
        u3.setUsername("User3");

        u = userService.createNewUser(u);   // Create the user in database to use just for this test
        u2 = userService.createNewUser(u2);   // Create the user in database to use just for this test
        u3 = userService.createNewUser(u3);   // Create the user in database to use just for this test

        // Create an Instrument w/ user that this instrument should be mapped to
        Instrument i = new Instrument();
        i.setUser(u);
        i.setConfidence(10);

        // Create an Instrument w/ user that this instrument should be mapped to
        Instrument i2 = new Instrument();
        i2.setUser(u2);
        i2.setConfidence(10);

        // Create an Instrument w/ user that this instrument should be mapped to
        Instrument i3 = new Instrument();
        i3.setUser(u3);
        i3.setConfidence(10);


        // Create/persist the Instrument
        instrumentService.createNewInstrument(i, u);

        // Create/persist the Instrument
        instrumentService.createNewInstrument(i2, u2);

        // Create/persist the Instrument
        instrumentService.createNewInstrument(i3, u3);

        // Get all persisted instruments
        List<Instrument> listing = instrumentService.findListByConfidence(10);

        assertNotNull(listing);

        for (Instrument iS: listing)
        {
            System.out.println(iS.getConfidence());             // Print Confidence
            System.out.println(iS.getUser().getUsername());     // Print Username
            assertEquals(10, iS.getConfidence());       // Check that the confidence matches
        }
    }
}
