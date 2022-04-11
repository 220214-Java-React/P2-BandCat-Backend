package com.bandcat.BandCat.service;

import com.bandcat.BandCat.model.User;
import com.bandcat.BandCat.repo.UserRepo;
import org.springframework.stereotype.Service;

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
    final private UserRepo userRepo;

    /**
     * @author Marcus
     * Constructor -> Spring will pass in UserRepo instance
     * @param uR The instance of UserRepo needed
     */
    public UserService(UserRepo uR)
    {
        this.userRepo = uR;
    }

    /**
     * @author Marcus
     * Method -> Creates a new user/Updates a user
     * @param user The User to persist
     *
     * @return The User that was persisted
     */
    public User createNewUser(User user)
    {
       return userRepo.save(user);
    }

    /**
     * @author Elaine, Jazib, Marcus
     * Method -> Gets a list of all Users
     * @return List of Users
     */
    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }

    /**
     * @author Elaine, Jazib, Marcus
     * Method -> Searches for a User based on username
     * @param username The username to search by
     * @return The User found
     */
    public User findByUsername(String username)
    {
        return userRepo.findByUsername(username);
    }

    /**
     * @author Jazib
     * Method -> Searches for a User based on User ID
     * @param id The User ID to search by
     * @return The User found
     */
    public User findByUserID(Integer id){

        return userRepo.findById(id).orElse(new User());

    }

    /**
     * @author Jazib and Marcus
     * Method -> Deletes a user
     * @param user The User to delete
     */
    public void deleteUser(User user)
    {
        userRepo.delete(user);
    }
}


