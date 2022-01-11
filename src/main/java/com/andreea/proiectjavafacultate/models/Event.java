package com.andreea.proiectjavafacultate.models;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Event {
    private Set<Model> models;
    private Date event_date;
    private String event_name;

    public Event() {
        this.models = new TreeSet<Model>(Comparator.comparing(Model::getBirthday).reversed());
        this.event_date = new Date(); // TODO: Preluata data din stringul parametru
    }

    public Event(String name) {
        this.event_name = name;
        this.models = new TreeSet<Model>(Comparator.comparing(Model::getBirthday).reversed());
        this.event_date = new Date();// TODO: Preluata data din stringul parametru
    }

    public Event(String name, Date date) {
        this.event_name = name;
        this.models = new TreeSet<Model>(Comparator.comparing(Model::getBirthday).reversed());
        this.event_date = date;// TODO: Preluata data din stringul parametru
    }

    @Override
    public String toString() {
        return "Event{" +
                "models=" + models +
                ", event_date=" + event_date +
                ", event_name='" + event_name + '\'' +
                '}';
    }

    public Event(String name, String event_date) {
        this.event_name = name;
        this.models = new TreeSet<Model>(Comparator.comparing(Model::getBirthday).reversed());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            Date date = formatter.parse(event_date);
            this.event_date = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public void addModel(Model x) {
        try {
            this.models.add(x);
        } catch (NullPointerException e) {
            System.out.println("Model invalid - NULL");
        }
    }

    public void delModel(Model x) {
        this.models.remove(x);
    }

    public void printModels() {
        try {
            this.models.stream()
                    .forEach(element -> System.out.println(element.getNume() + " " + element.getPrenume() + " " + element.getBirthday()));
        } catch (NullPointerException e) {
            System.out.println("Nu exista nici un model valid. Toti sunt NULL");
        }
    }

    public Set<Model> getModels() {
        return this.models;
    }
}