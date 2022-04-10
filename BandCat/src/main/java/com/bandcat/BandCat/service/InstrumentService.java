package com.bandcat.BandCat.service;

import com.bandcat.BandCat.model.Instrument;
import com.bandcat.BandCat.repo.InstrumentRepo;
import org.springframework.stereotype.Service;

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

    /**
     * Constructor -> Spring will pass in InstrumentRepo instance
     * @param iR The instance of InstrumentRepo needed
     */
    public InstrumentService(InstrumentRepo iR)
    {
        this.instrumentRepo = iR;
    }

    /**
     * @author Marcus
     * Method -> Creates a new instrument
     * @param instrument The User to persist
     * @return The Instrument that was persisted
     */
    public Instrument createNewInstrument(Instrument instrument)
    {
        return instrumentRepo.save(instrument);
    }
}
