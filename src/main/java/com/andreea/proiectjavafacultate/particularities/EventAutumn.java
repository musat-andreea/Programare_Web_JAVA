package com.andreea.proiectjavafacultate.particularities;

import com.andreea.proiectjavafacultate.models.Event;

public class EventAutumn extends Event {

    public EventAutumn(String name) {
        super(name);
    }

    @Override
    public String getEvent_name() {
        return super.getEvent_name() + " - Evenimente Toamna";
    }

}
