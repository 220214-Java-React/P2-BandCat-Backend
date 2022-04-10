package com.bandcat.BandCat.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This class is designed to create Tests for Instrument models.
 */
public class InstrumentTests
{
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
    @DisplayName("Test for the creation of a new Instrument")
    public void canCreateANewInstrumentObj()
    {
        Instrument i = new Instrument();

        assertNotNull(i);
    }

    /**
     * @author Marcus
     */
    @Test
    @DisplayName("Test for Instrument Name initialization")
    public void doesEnumWork()
    {
        Instrument i = new Instrument(1, InstrumentOptions.GUITAR, 10, new User());

        assertEquals(InstrumentOptions.GUITAR, i.getInstrumentName());
    }
}
