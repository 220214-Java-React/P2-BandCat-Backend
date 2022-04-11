package com.bandcat.BandCat.repo;

import com.bandcat.BandCat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.ResponseWrapper;

/**
 * This class is designed to handle the persistence logic
 * between Services and Database, for Users.
 * Spring, JpaRepository, CrudRepository, etc. contain the logic
 * to persist data to a database.
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername (String username);
}
