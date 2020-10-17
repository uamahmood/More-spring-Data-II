package com.umermahmood.EventsBeltReviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umermahmood.EventsBeltReviewer.models.Event;

@Repository
public interface EventRepo extends CrudRepository <Event, Long> {

}