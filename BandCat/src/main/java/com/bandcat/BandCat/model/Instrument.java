package com.bandcat.BandCat.model;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity (name = "instruments")
@RequiredArgsConstructor
@Getter
@Setter
public class Instrument {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int InstrumentID;
    private String instrumentName;
    private int confidence;

}
