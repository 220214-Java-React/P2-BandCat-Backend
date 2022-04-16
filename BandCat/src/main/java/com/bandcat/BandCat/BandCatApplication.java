package com.bandcat.BandCat;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BandCatApplication {

	public static void main(String[] args) {
		SpringApplication.run(BandCatApplication.class, args);
	}

	@Bean
	public Logger getTheLogger()
	{
		return LogManager.getLogger();
	}

	@Bean
	public BCrypt.Hasher getHasher()
	{
		return BCrypt.withDefaults();
	}
}
