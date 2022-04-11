package com.bandcat.BandCat.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
/**
 * By: Elaine R. Constancio
 */

public class InstrumentTests
{
    @Test
    public void TestClassWorks()
    {
        assertTrue(true);
    }

    @Test
    @DisplayName("Test for the creation of a new Instrument")
    public void canCreateANewInstrumentObj()
    {
        Instrument i = new Instrument();

        assertNotNull(i);
    }

}
