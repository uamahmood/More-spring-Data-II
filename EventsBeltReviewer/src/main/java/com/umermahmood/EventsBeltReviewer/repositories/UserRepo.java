package com.umermahmood.EventsBeltReviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umermahmood.EventsBeltReviewer.models.User;

@Repository
public interface UserRepo extends CrudRepository <User, Long> {
	  User findByEmail(String email);
}
