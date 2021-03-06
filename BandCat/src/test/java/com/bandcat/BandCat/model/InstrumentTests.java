package com.bandcat.BandCat.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest //Note from christian: please take a look and make sure this is needed
/**
 * By: Elaine R. Constancio
 */
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


    /**
     * @author Elaine & Marcus
     */
    @Test
    @DisplayName("Test for Instrument Name initialization")
    public void doesEnumWork2()
    {
        Instrument i = new Instrument(1, InstrumentOptions.PIANO, 10, new User());

        assertEquals(InstrumentOptions.PIANO, i.getInstrumentName());
    }
    @Test
    @DisplayName("Test for Instrument Name initialization")
    public void doesEnumWork3()
    {
        Instrument i = new Instrument(1, InstrumentOptions.SAXOPHONE, 10, new User());

        assertEquals(InstrumentOptions.SAXOPHONE, i.getInstrumentName());
    }
    @Test
    @DisplayName("Test for Instrument Name initialization")
    public void doesEnumWork4()
    {
        Instrument i = new Instrument(1, InstrumentOptions.TRUMPET, 10, new User());

        assertEquals(InstrumentOptions.TRUMPET, i.getInstrumentName());
    }
    @Test
    @DisplayName("Test for Instrument Name initialization")
    public void doesEnumWork5()
    {
        Instrument i = new Instrument(1, InstrumentOptions.CLARINET, 10, new User());

        assertEquals(InstrumentOptions.CLARINET, i.getInstrumentName());
    }


}
