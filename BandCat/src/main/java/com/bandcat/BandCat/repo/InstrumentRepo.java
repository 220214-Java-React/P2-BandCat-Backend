package com.bandcat.BandCat.repo;

import com.bandcat.BandCat.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class is designed to handle the persistence logic
 * between Services and Database, for Instruments.
 * Spring, JpaRepository, CrudRepository, etc. contain the logic
 * to persist data to a database.
 */
@Repository
public interface InstrumentRepo extends JpaRepository<Instrument, Integer> {}
