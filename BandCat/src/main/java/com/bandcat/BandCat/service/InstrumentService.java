package com.bandcat.BandCat.service;

import com.bandcat.BandCat.repo.InstrumentRepo;
import org.springframework.stereotype.Service;

@Service
public class InstrumentService
{
    private InstrumentRepo instrumentRepo;

    public InstrumentService(InstrumentRepo iR)
    {
        this.instrumentRepo = iR;
    }
}
