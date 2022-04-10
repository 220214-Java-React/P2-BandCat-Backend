package com.bandcat.BandCat.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
     */
    @Autowired
    InstrumentService instrumentService;    // Service to use

    /**
     * @author Marcus
     */
    @Test
    public void TestClassWorks()
    {
        assertTrue(true);
    }



}
