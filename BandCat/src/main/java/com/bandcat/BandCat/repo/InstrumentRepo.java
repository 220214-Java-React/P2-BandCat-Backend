package com.bandcat.BandCat.repo;

import com.bandcat.BandCat.model.Instrument;
import com.bandcat.BandCat.model.InstrumentOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class is designed to handle the persistence logic
 * between Services and Database, for Instruments.
 * Spring, JpaRepository, CrudRepository, etc. contain the logic
 * to persist data to a database.
 */
@Repository
public interface InstrumentRepo extends JpaRepository<Instrument, Integer>
{
    /**
     * @see com.bandcat.BandCat.service.InstrumentService#findByName(InstrumentOptions)
     */
    Instrument findByInstrumentName(InstrumentOptions instrumentName);

    /**
     * @see com.bandcat.BandCat.service.InstrumentService#findByConfidence(Integer) 
     */
    Instrument findByConfidence(Integer confidence);

    /**
     * @see com.bandcat.BandCat.service.InstrumentService#findListByInstrumentName(InstrumentOptions) 
     */
    List<Instrument> findListByInstrumentName(InstrumentOptions instrumentName);

    /**
     * @see com.bandcat.BandCat.service.InstrumentService#findListByConfidence(Integer) 
     */
    List<Instrument> findListByConfidence(Integer confidence);
}
