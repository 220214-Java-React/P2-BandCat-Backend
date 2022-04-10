package com.bandcat.BandCat.model;

/**
 * @author Marcus
 * Enum that pre-defines the options for Instrument choices
 */
public enum InstrumentOptions
{
    /**
     * Choices of instruments
     */
    NONE("None"),
    GUITAR("Guitar"),
    PIANO("Piano"),
    SAXOPHONE("Saxophone"),
    TRUMPET("Trumpet"),
    CLARINET("Clarinet");

    /**
     * String reference of each enum
     */
    private final String instrumentName;

    /**
     * Private Constructor -> Sets the Enums
     * @param instrumentName String representation of the Enum
     */
    InstrumentOptions(String instrumentName) {this.instrumentName = instrumentName;}

    /**
     * Getter -> Gets the String value of an enum
     * @return The Enum's String representation
     */
    public String getInstrumentName() {return instrumentName;}
}