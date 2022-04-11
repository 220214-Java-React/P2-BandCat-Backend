package com.bandcat.BandCat.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * @author https://www.baeldung.com/jpa-persisting-enums-in-jpa
 * Marcus
 * This class is used by JPA to handle the conversion of
 * the InstrumentOptions enum into a String for DB persistence and vice versa.
 */
@Converter(autoApply = true)
public class InstrumentOptionConverter implements AttributeConverter<InstrumentOptions, String>
{
    /**
     * Converts an InstrumentOptions into a String for Database persistence
     * @param instrumentOptions Enum to convert
     * @return String representation of Enum
     */
    @Override
    public String convertToDatabaseColumn(InstrumentOptions instrumentOptions)
    {
        if (instrumentOptions == null)
        {
            return null;
        }

        return instrumentOptions.getInstrumentName();
    }

    /**
     * Converts a String into an InstrumentOptions enum
     * @param instrumentName String to convert
     * @return Converted Enum
     */
    @Override
    public InstrumentOptions convertToEntityAttribute(String instrumentName)
    {
        if (instrumentName == null)
        {
            return null;
        }

        return Stream.of(InstrumentOptions.values())                                    // Of the Enums declared in InstrumentOptions
                .filter((inName) -> inName.getInstrumentName().equals(instrumentName))  // Filter the enum with the matching name
                .findFirst()                                                            // Return the first element found as an Optional<InstrumentOptions>
                .orElseThrow(IllegalArgumentException::new);                            // Return the Optional or throw an exception if there is no value to return
    }
}