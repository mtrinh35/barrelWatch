package com.matthewtrinh.barrelwatch;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class SurfSession 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double minWaveHeight;
    private double maxWaveHeight;
    private int rating;
    private String location;
    private String timeOfDay;
    private LocalDate date;
    //              YYYY-MM-DD

    public SurfSession(){}
    
    // Parameterized constructor, omit ID
    public SurfSession(double minWaveHeight, double maxWaveHeight, int rating, String location, String timeOfDay, LocalDate date)
    {
        this.minWaveHeight = minWaveHeight;
        this.maxWaveHeight = maxWaveHeight;
        this.rating = rating;
        this.location = location;
        this.timeOfDay = timeOfDay;
        this.date = date;
    }

    public int getId()
    {
        return id;
    }

    public double getMinWaveHeight()
    {
        return minWaveHeight;
    }

    public double getMaxWaveHeight()
    {
        return maxWaveHeight;
    }

    public int getRating()
    {
        return rating;
    }

    public String getLocation()
    {
        return location;
    }

    public String getTimeOfDay()
    {
        return timeOfDay;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setMinWaveHeight(double minWaveHeight)
    {
        this.minWaveHeight = minWaveHeight;
    }

    public void setMaxWaveHeight(double maxWaveHeight)
    {
        this.maxWaveHeight = maxWaveHeight;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public void setTimeOfDay(String timeOfDay) 
    {
        this.timeOfDay = timeOfDay;
    }

    public void setDate(LocalDate date) 
    {
        this.date = date;
    }
}

