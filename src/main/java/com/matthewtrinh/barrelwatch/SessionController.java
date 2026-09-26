package com.matthewtrinh.barrelwatch;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController 
{
    private final SurfSessionRepository repository;

    public SessionController(SurfSessionRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/sessions")
    public List<SurfSession> getSessions()
    {
        return repository.findAll();
    }

    // 
    @GetMapping("/sessions/{id}")
    public SurfSession getSessionById(@PathVariable int id)
    {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/sessions")
    public SurfSession addSession(@RequestBody SurfSession session)
    {
        return repository.save(session);
    }
}




