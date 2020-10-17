package com.umermahmood.EventsBeltReviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umermahmood.EventsBeltReviewer.models.Message;

@Repository
public interface MessageRepo extends CrudRepository <Message, Long>{

}