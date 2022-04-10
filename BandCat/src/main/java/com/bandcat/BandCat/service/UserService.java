package com.bandcat.BandCat.service;

import com.bandcat.BandCat.model.User;
import com.bandcat.BandCat.repo.UserRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
     * @author Marcus
     * Constructor -> Spring will pass in UserRepo instance
     * @param uR The instance of UserRepo needed
     */
    public UserService(UserRepo uR)
    {
        this.userRepository = uR;
    }

    /**
     * @author Marcus
     * Method -> Creates a new user
     * @param user The User to persist
     * @return The User that was persisted
     */
    public User createNewUser(User user)
    {
       return userRepository.save(user);
    }

    /**
     * @author Elaine, Jazib, Marcus
     * Method -> Gets a list of all Users
     * @return List of Users
     */
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    /**
     * @author Elaine, Jazib, Marcus
     * Method -> Searches for a User based on username
     * @param username The username to search by
     * @return The User found
     */
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }


    /**
     * @author Jazib
     * Method -> Searches for a User based on User ID
     * @param id The User ID to search by
     * @return The User found
     */
    public User getByUserID(Integer id){

        return userRepository.findById(id).orElse(new User());

    }
}
