package com.andreea.proiectjavafacultate.models;

public class Location {
    int id;
    int eventId;
    String city;
    String country;
    String capacity;
    Boolean status;

    public Location() {

    }

    public Location(int id) {
        this.id = id;
        this.eventId = 0;
        this.city = "";
        this.country = "";
        this.capacity = "";
        this.status = false;
    }

    public Location(String city) {
        this.city = city;
        this.country = "Test";
        this.capacity = "Test";
        this.status = true;
        System.out.println("S-a construit obiectu");
        System.out.println(this.country);
    }

    public Location(int id, String city) {
        this.id = id;
        this.city = city;
        this.country = "";
        this.capacity = "";
        this.status = true;
    }
    public Location(int eventId, String city, String country, String capacity, Boolean status) {
        this.eventId = eventId;
        this.city = city;
        this.country = country;
        this.capacity = capacity;
        this.status = status;
    }

    public Location(int id, int eventId, String city, String country, String capacity, Boolean status) {
        this.id = id;
        this.eventId = eventId;
        this.city = city;
        this.country = country;
        this.capacity = capacity;
        this.status = status;
    }


    public void assignEventId(int eventId)  {
        this.eventId = eventId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", capacity='" + capacity + '\'' +
                ", status=" + status +
                '}';
    }
}
