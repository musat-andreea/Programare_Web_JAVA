package com.andreea.proiectjavafacultate.models;

import java.util.*;

public class Designer {
    private Set<Model> models;
    int eventId;
    String nume;

    public Designer()   {
        this.models = new TreeSet<Model>(Comparator.comparing(Model::getBirthday).reversed());
        this.nume = "";
        this.eventId = 0;
    }

    public Designer(String nume) {
        this.models = new TreeSet<Model>(Comparator.comparing(Model::getBirthday).reversed());
        this.nume = nume;
        this.eventId = 0;
    }
    public Designer(int eventId, String nume) {
        this.models = new TreeSet<Model>(Comparator.comparing(Model::getBirthday).reversed());
        this.nume = nume;
        this.eventId = eventId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void addModel(Model x) {
        try {
            this.models.add(x);
        } catch (NullPointerException e) {
            System.out.println("Model invalid - NULL");
        }
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }
}
