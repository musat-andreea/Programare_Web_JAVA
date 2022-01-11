package com.andreea.proiectjavafacultate.models;

import java.util.ArrayList;
import java.util.List;

public class Agency {
    List<Event> events;
    String nume;
    int id;

    public Agency() {
        this.events = new ArrayList<Event>();
    }

    public Agency(String nume)
    {
        this.nume = nume;
        this.events = new ArrayList<Event>();
    }

    public Agency(int id, String nume)
    {
        this.id = id;
        this.nume = nume;
        this.events = new ArrayList<Event>();
    }


    public void addEvent(Event e)    {
        this.events.add(e);
    }

    public String getName() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void delEvent(Event e)    {
        this.events.remove(e);
    }

    public void printEvents()    {
        this.events.stream()
                .forEach(element -> System.out.println(element.getEvent_name() + " " + element.getEvent_date()));
    }

    @Override
    public String toString() {
        return "Agency{" +
                "events=" + events +
                ", nume='" + nume + '\'' +
                ", id=" + id +
                '}';
    }

    public List<Event> getEvents() {
        return this.events;
    }
}
