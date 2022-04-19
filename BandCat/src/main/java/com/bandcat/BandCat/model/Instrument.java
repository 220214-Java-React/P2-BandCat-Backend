package com.bandcat.BandCat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

/**
 * This class is designed to contain the data structure of Instruments
 * for data that moves around the application.
 * Spring, Lombok, Hibernate, etc. contain the logic
 * to create constructors, getters, setters, etc.
 * as well as associate different models to construct database tables.
 */
@Builder
@Entity(name = "instruments")       // Indicates an Object of this type is persistable
@RequiredArgsConstructor            // Creates constructor with required fields (fields w/ final fields and fields with constraints such as @NonNull)
@AllArgsConstructor                 // Creates an all args constructor
@Getter                             // Creates getters
@Setter                             // Creates setters
public class Instrument {
    /**
     * Instrument Fields
     */
    @Id
    @Column(name = "user_id")
    private int instrumentID;
    private InstrumentOptions instrumentName;
    private int confidence;

    /**
     * Also an Instrument Field
     * Foreign Key to reference a User associating an Instrument to its owner (User)
     */
    @OneToOne   // Relationship with Users
    @MapsId     // Maps this Instrument to the primary key of User
    @JoinColumn(name = "user_id")   // The column that connects Users and Instruments
    @JsonIgnore
    private User user;
}
