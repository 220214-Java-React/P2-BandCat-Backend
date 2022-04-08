package com.bandcat.BandCat.service;

import com.bandcat.BandCat.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private UserRepo userRepository;

    public UserService(UserRepo uR)
    {
        this.userRepository = uR;
    }
}
