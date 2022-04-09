package com.bandcat.BandCat.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name = "users")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "instrumentID", referencedColumnName = "instrumentID")
    private Instrument instrument;
}
