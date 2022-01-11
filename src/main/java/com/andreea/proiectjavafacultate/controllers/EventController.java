package com.andreea.proiectjavafacultate.controllers;


import com.andreea.proiectjavafacultate.models.Model;
import com.andreea.proiectjavafacultate.models.Event;
import com.andreea.proiectjavafacultate.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping(value= "/**", method=RequestMethod.POST)
    public void corsHeaders1(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "null");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
        response.addHeader("Access-Control-Max-Age", "3600");
    }

    @RequestMapping(value= "/**", method=RequestMethod.OPTIONS)
    public void corsHeaders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "null");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
        response.addHeader("Access-Control-Max-Age", "3600");
    }
    @RequestMapping(value = "/events")
    public List<Event> getAllEvents()
    {
        return eventService.getAllEvents();
    }

    @RequestMapping(value = "/events/{id}")
    public Event getEventsById(@PathVariable int id)
    {
        return eventService.getEvent(id);
    }

    @RequestMapping(value = "/getEventId/{name}")
    public int getEventsById(@PathVariable String name)
    {
        return eventService.getEventId(name);
    }

    @RequestMapping(value = "/getEventModels/{id}")
    public List<Model> getEventModels(@PathVariable int id)
    {
        return eventService.listHeightModels(id, "height");
    }

    @RequestMapping(value = "/addEvent", method = RequestMethod.POST)
    public boolean addEvent(@RequestBody Event c)
    {
        return eventService.addEvent(c);
    }

    @RequestMapping(value = "/updateEventDate", method = RequestMethod.POST)
    public boolean updateMedie(@RequestParam("id") int id, @RequestParam("data") Date d) //// ceeeeeeeeeeeeeee fac cu update medie
    {
        return eventService.updateEventDate(id, (java.sql.Date) d);
    }

    @RequestMapping(value = "/addEventToAgency", method = RequestMethod.POST, consumes = "application/json")
    public boolean enrollModel(@RequestBody Map<String, Integer> json)
    {
        int eventId = json.get("eventId");
        int agencyId = json.get("agencyId");
        return eventService.enrollToAgency(eventId, agencyId);
    }

    @RequestMapping(value = "/delEvent/{id}", method = RequestMethod.POST)
    public boolean deleteEvent(@PathVariable int id)
    {
        return eventService.deleteEvent(id);
    }

}
