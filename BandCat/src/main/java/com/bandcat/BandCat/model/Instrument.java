package com.bandcat.BandCat.model;
import lombok.*;

import javax.persistence.*;


@Entity (name = "instruments")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Instrument {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int instrumentID;
    private InstrumentOptions instrumentName;
    private int confidence;

    @OneToOne(mappedBy = "instrument")
    private User user;
}
