package com.andreea.proiectjavafacultate.controllers;

import com.andreea.proiectjavafacultate.models.Location;
import com.andreea.proiectjavafacultate.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;


    @RequestMapping(value = "/locations")
    public List<Location> getAllLocation()
    {
        return locationService.getAllLocations();
    }

    @RequestMapping(value = "/location/{id}")
    public Location getLocationById(@PathVariable int id)
    {
        return locationService.getLocation(id);
    }

    @RequestMapping(value = "/eventLocation/{id}")
    public List<Location> getLocationLocation(@PathVariable int id)
    {
        return locationService.getEventLocation(id);
    }

    @RequestMapping(value = "/addLocation", method = RequestMethod.POST)
    public boolean addLocation(@RequestBody Location c)
    {
        System.out.println("ajunge in ruta============================");
        return locationService.addLocation(c);
    }

    @RequestMapping(value = "/delLocation/{id}", method = RequestMethod.POST)
    public boolean deleteLocation(@PathVariable int id)
    {
        return locationService.deleteLocation(id);
    }

}
