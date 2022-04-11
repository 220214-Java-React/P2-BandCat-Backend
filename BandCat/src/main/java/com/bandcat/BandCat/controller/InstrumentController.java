package com.bandcat.BandCat.controller;

import com.bandcat.BandCat.model.Instrument;
import com.bandcat.BandCat.model.User;
import com.bandcat.BandCat.service.InstrumentService;
import com.bandcat.BandCat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This class is designed to handle requests/responses for Instrument-based
 * tasks between the frontend and Service.
 * Spring, Spring Web, etc. contain the logic needed to
 * manage requests sent to the API and responses sent outward.
 */
@RestController
@RequestMapping("/instruments")
public class InstrumentController
{
    @Autowired
    InstrumentService instrumentService;

    @Autowired
    UserService userService;

    //TODO: Figure out how to place this in postman, do I need new User in my return?
    /**
     * Method to create new Instrument from a http request
     * @author Tyler, Marcus, Elaine, Christian
     * @param instrument
     *
     */
    @PostMapping("/{id}")
    public Instrument createInstrument(@RequestBody Instrument instrument, @PathVariable int id)
    {
        User u = userService.findByUserID(id);
        return instrumentService.createNewInstrument(instrument, u);
    }
}
