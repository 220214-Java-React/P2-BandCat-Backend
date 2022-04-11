package com.bandcat.BandCat.service;

import com.bandcat.BandCat.model.Instrument;
import com.bandcat.BandCat.model.InstrumentOptions;
import com.bandcat.BandCat.model.User;
import com.bandcat.BandCat.repo.InstrumentRepo;
import com.bandcat.BandCat.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is designed to handle the processing logic
 * between Controllers and Repo, for Instruments. It should be used for
 * validation, reference checking, response preparation, etc.
 */
@Service
public class InstrumentService
{
    /**
     * Reference to an InstrumentRepo instance
     */
    final private InstrumentRepo instrumentRepo;
    final private UserRepo userRepo;
    final private UserService userService;

    /**
     * Constructor -> Spring will pass in InstrumentRepo instance
     * @param iR The instance of InstrumentRepo needed
     */
    public InstrumentService(InstrumentRepo iR, UserRepo uR, UserService uS)
    {
        this.instrumentRepo = iR;
        this.userRepo = uR;
        this.userService = uS;
    }

    /**
     * @author Marcus
     * Method -> Creates a new instrument via updating a User's Instrument field
     * @param instrument The Instrument to persist
     * @param userToUpdate The User to update
     * @return The Instrument that was persisted
     */
    public Instrument createNewInstrument(Instrument instrument, User userToUpdate)
    {
        // Get the user to update, also to assign their instrument
        userToUpdate = userRepo.findByUsername(userToUpdate.getUsername());

        // Set the new Instrument's User
        instrument.setUser(userToUpdate);

        // Set the User's instrument
        userToUpdate.setInstrument(instrument);

        // Update user in database which also creates the Instrument record
        userToUpdate = userService.createNewUser(userToUpdate);

        // Return the instrument created
        return userToUpdate.getInstrument();
    }

    /**
     * @author Jazib and Marcus
     * Method -> Gets all instruments which are tied to User IDs
     * @return The list of Instruments
     */
    public List<Instrument> getAllInstruments()
    {
        return instrumentRepo.findAll();
    }

    /**
     * Method -> Gets a list Instrument based on the Name
     * @author Jazib and Marcus
     * @param instrumentName The Name search criteria
     * @return The Instrument found
     */
    public List<Instrument> findListByInstrumentName(InstrumentOptions instrumentName)
    {
        return instrumentRepo.findListByInstrumentName(instrumentName);
    }

    /**
     * Method -> Gets a list of Instruments based on the Confidence
     * @author Jazib and Marcus
     * @param confidence The confidence search criteria
     * @return The Instruments Found
     */
    public List<Instrument> findListByConfidence(Integer confidence)
    {
        return instrumentRepo.findListByConfidence(confidence);
    }
}
