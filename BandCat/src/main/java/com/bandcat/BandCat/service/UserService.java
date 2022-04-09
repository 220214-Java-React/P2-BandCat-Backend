package com.bandcat.BandCat.service;

import com.bandcat.BandCat.model.User;
import com.bandcat.BandCat.repo.UserRepo;
import org.springframework.stereotype.Service;

/**
 * This class is designed to handle the processing logic
 * between Controllers and Repo, for Users. It should be used for
 * validation, reference checking, response preparation, etc.
 */
@Service
public class UserService
{
    /**
     * Reference to UserRepo instance
     */
    final private UserRepo userRepository;

    /**
     * Constructor -> Spring will pass in UserRepo instance
     * @param uR The instance of UserRepo needed
     */
    public UserService(UserRepo uR)
    {
        this.userRepository = uR;
    }

    /**
     * Method -> Creates a new user
     * @param user The User to persist
     * @return The User that was persisted
     */
    public User createNewUser(User user)
    {
       return userRepository.save(user);
    }
}
