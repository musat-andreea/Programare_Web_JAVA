package com.andreea.proiectjavafacultate.models;


public class Model {
    private int id;
    private String nume;
    private String prenume;
    private float height;
    private float weight;
    private float birthday;

    public  Model()
    {


    }
    public Model(String nume, String prenume)
    {
        this.nume = nume;
        this.prenume = prenume;
    }

    public Model(String nume, String prenume, float height)
    {
        this.nume = nume;
        this.prenume = prenume;
        this.height = height;
    }

    public Model(String nume, String prenume, float height, float weight)
    {
        this.nume = nume;
        this.prenume = prenume;
        this.height = height;
        this.weight = weight;
    }


    public Model(int id, String nume, String prenume, float height, float weight, float birthyear)
    {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.height = height;
        this.weight = weight;
        this.birthday = birthyear;
    }


    public Model(int id, String nume, String prenume, float height, float weight)
    {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.height = height;
        this.weight = weight;
    }

    public float getWeight() {
        return this.weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getBirthday() {
        return birthday;
    }

    public void setBirthday(float birthday) {
        this.birthday = birthday;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Model{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", birthday=" + birthday +
                '}';
    }
}
