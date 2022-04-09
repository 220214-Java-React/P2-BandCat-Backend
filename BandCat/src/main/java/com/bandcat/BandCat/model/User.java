package com.bandcat.BandCat.model;

import lombok.*;
import javax.persistence.*;

/**
 * This class is designed to contain the data structure of Users
 * for data that moves around the application.
 * Spring, Lombok, Hibernate, etc. contain the logic
 * to create constructors, getters, setters, etc.
 * as well as associate different models to construct database tables.
 */
@Entity(name = "users")     // Indicates an Object of this type is persistable
@RequiredArgsConstructor    // Creates constructor with required fields (fields w/ final fields and fields with constraints such as @NonNull)
@AllArgsConstructor         // Creates an all args constructor
@Getter                     // Creates getters
@Setter                     // Creates setters
public class User
{
    /**
     * User Fields
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    /**
     * Also a User Field
     * Foreign Key to reference an Instrument associating a User to their Instrument
     */
    @OneToOne   // Relationship with Instruments
    @JoinColumn(name = "instrumentID", referencedColumnName = "instrumentID")   // Joining column -> name = name of join column, refColName = column name of an Instrument to reference when joining
    private Instrument instrument;
}
