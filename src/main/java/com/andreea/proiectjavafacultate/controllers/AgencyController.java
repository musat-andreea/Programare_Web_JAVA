package com.andreea.proiectjavafacultate.controllers;

import com.andreea.proiectjavafacultate.models.Event;
import com.andreea.proiectjavafacultate.models.Agency;
import com.andreea.proiectjavafacultate.services.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @RequestMapping(value = "/agencies")
    public List<Agency> getAllAgency()
    {
        return agencyService.getAllAgency();
    }

    @RequestMapping(value = "/agency/{id}")
    public Agency getAgencyById(@PathVariable int id)
    {
        return agencyService.getAgency(id);
    }

    @RequestMapping(value = "/agencyEvents/{id}")
    public List<Event> listAgencyEvents(@PathVariable int id)
    {
        return agencyService.listAgencyEvents(id);
    }

    @RequestMapping(value = "/addAgency", method = RequestMethod.POST)
    public boolean addAgency(@RequestBody Agency c)
    {
        return agencyService.addAgency(c);
    }

    @RequestMapping(value = "/delAgency/{id}", method = RequestMethod.POST)
    public boolean deleteAgency(@PathVariable int id)
    {
        return agencyService.deleteAgency(id);
    }

}
