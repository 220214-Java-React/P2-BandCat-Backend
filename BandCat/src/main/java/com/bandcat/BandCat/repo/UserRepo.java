package com.bandcat.BandCat.repo;

import com.bandcat.BandCat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.ResponseWrapper;

import java.util.List;
import java.util.Optional;

/**
 * This class is designed to handle the persistence logic
 * between Services and Database, for Users.
 * Spring, JpaRepository, CrudRepository, etc. contain the logic
 * to persist data to a database.
 */
@Repository

public interface UserRepo extends JpaRepository<User, Integer>
{
    /**
     * @author Elaine, Jazib, Marcus
     * Method to find a User based on its username
     * @param username The username to search for
     * @return The User found
     */
    Optional<User> findByUsername(String username);
}
