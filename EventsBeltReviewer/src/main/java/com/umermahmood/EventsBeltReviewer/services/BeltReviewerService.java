package com.umermahmood.EventsBeltReviewer.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umermahmood.EventsBeltReviewer.models.Event;
import com.umermahmood.EventsBeltReviewer.models.Message;
import com.umermahmood.EventsBeltReviewer.models.User;
import com.umermahmood.EventsBeltReviewer.repositories.EventRepo;
import com.umermahmood.EventsBeltReviewer.repositories.MessageRepo;
import com.umermahmood.EventsBeltReviewer.repositories.UserEventRepo;
import com.umermahmood.EventsBeltReviewer.repositories.UserRepo;

@Service
public class BeltReviewerService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private EventRepo eventRepo;
	@Autowired
	private UserEventRepo userEventRepo;
	@Autowired
	private MessageRepo messageRepo;
	
	public void deleteEvent(Long id) {
		eventRepo.deleteById(id);
	}
	
    public List<Event> allEvents() {
    	return (List<Event>) eventRepo.findAll();
    }
	
	public Event addEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public Message addMessage(Message message) {
		return messageRepo.save(message);
	}
	
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }
    
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    
    public User findUserById(Long id) {
    	Optional<User> u = userRepo.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	}
    	else {
    	    return null;
    	}
    }
    
    public Event findEventById(Long id) {
    	Optional<Event> e = eventRepo.findById(id);
    	if(e.isPresent()) {
            return e.get();
    	}
    	else {
    	    return null;
    	}
    }
    
    public void updateEvent(Event event) {
        eventRepo.save(event);
    }
    
    public void updateUser(User user) {
        userRepo.save(user);
    }
    
    public void updateMessage(Message message) {
    	messageRepo.save(message);
    }
    
    public void newMessage(Message message) {
        messageRepo.save(message);
    }
    
    //Authentication
    public boolean authenticateUser(String email, String password) {
        User user = userRepo.findByEmail(email);
        if(user == null) {
            return false;
        }
        else {
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    public boolean duplicateUser(String email) {
        User user = userRepo.findByEmail(email);
        if(user == null) {
            return false;
        }
        else {
        	return true;
        }
    }
}
