package com.bandcat.BandCat.service;

import com.bandcat.BandCat.model.Instrument;
import com.bandcat.BandCat.model.InstrumentOptions;
import com.bandcat.BandCat.model.User;
import com.bandcat.BandCat.repo.InstrumentRepo;
import com.bandcat.BandCat.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        userToUpdate = userRepo.findByUsername(userToUpdate.getUsername()).orElseThrow(() -> new RuntimeException("No User was found!"));

        // Set the new Instrument's User
        instrument.setUser(userToUpdate);

        // Set the User's instrument
        userToUpdate.setInstrument(instrument);

        // Update user in database which also creates the Instrument record
        userToUpdate = userService.updateUser(userToUpdate);

        // Return the instrument created
        return userToUpdate.getInstrument();
    }

    /**
     * Method -> Gets an Instrument by ID
     * @author Tyler, Marcus
     * @param id ID search criteria
     * @return The Instrument found
     */
    public Instrument getByInstrumentID(Integer id)
    {
        return instrumentRepo.getById(id);
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


    /**
     * @author Marcus
     * Method -> Gets the list of Users with a matching Instrument
     * @param instrument The Instrument search criteria
     * @return The List of Users found
     */
    public List<User> findListByInstrument(Instrument instrument)
    {
        List<User> usersFound = new ArrayList<>();
        List<Instrument> instruments = null;

        if (instrument.getInstrumentName() != InstrumentOptions.NONE && instrument.getConfidence() != 0)
        {
            // Search by name and confidence
            instruments = instrumentRepo.findListByInstrumentNameAndConfidence(instrument.getInstrumentName(), instrument.getConfidence());
        }
        else if (instrument.getInstrumentName() != InstrumentOptions.NONE)
        {
            // Search by name
            instruments = instrumentRepo.findListByInstrumentName(instrument.getInstrumentName());
        }
        else if (instrument.getConfidence() != 0)
        {
            // Search by confidence
            instruments = instrumentRepo.findListByConfidence(instrument.getConfidence());
        }
        else {
            instruments = instrumentRepo.findAll();
        }

        // If instruments were found
        if (instruments != null)
        {
            // Get the list of users based on this instrument
            for (Instrument i: instruments)
            {
                usersFound.add(userRepo.getById(i.getInstrumentID()));
            }
        }

        // Return the list of Users
        return usersFound;
    }
}
