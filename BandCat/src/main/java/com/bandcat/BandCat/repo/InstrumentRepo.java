package com.bandcat.BandCat.repo;

import com.bandcat.BandCat.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepo extends JpaRepository<Instrument, Integer>
{
}
