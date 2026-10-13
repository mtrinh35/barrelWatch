package com.matthewtrinh.barrelwatch;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * SessionController
 */
@RestController
public class SessionController 
{
    private final SurfSessionRepository repository;

    public SessionController(SurfSessionRepository repository)
    {
        this.repository = repository;
    }

    // Get all sessions
    // returns list of sessions or empty list
    @GetMapping("/sessions")
    public ResponseEntity<List<SurfSession>> getSessions() 
    {
        return ResponseEntity.ok(repository.findAll());
    }


    // Retrieve a session 
    @GetMapping("/sessions/{id}")
    public SurfSession getSessionById(@PathVariable int id)
    {
        return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
             "Cannot retrieve: session " + id + " does not exist"));
    }

    // Create session
    @PostMapping("/sessions") 
    public SurfSession addSession(@RequestBody SurfSession session)
    {
        return repository.save(session);
    }
    
    // Update existing session into session from updatedSession (getters/setters)
    @PutMapping("/sessions/{id}") 
    public SurfSession updateSession(@PathVariable int id, @RequestBody SurfSession updatedSession)
    {
        // execption will throw '404 Not found': 
        SurfSession session = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                "Cannot update: session " + id + " does not exist"));

        session.setMinWaveHeight(updatedSession.getMinWaveHeight()); 
        session.setMaxWaveHeight(updatedSession.getMaxWaveHeight()); 
        session.setRating(updatedSession.getRating()); 
        session.setLocation(updatedSession.getLocation());
        session.setTimeOfDay(updatedSession.getTimeOfDay()); 
        session.setDate(updatedSession.getDate());

        return repository.save(session);
    }

    // Delete session, check if session exists, if so, delete, else, throw 404
    @DeleteMapping("/sessions/{id}")
    public void deleteSurfSession(@PathVariable int id)
    {
        if (!repository.existsById(id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
                "Cannot delete: session " + id + " does not exist");
        }
        repository.deleteById(id);
    }
}




