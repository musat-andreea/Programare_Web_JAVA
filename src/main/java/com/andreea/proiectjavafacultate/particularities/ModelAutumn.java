package com.andreea.proiectjavafacultate.particularities;

import com.andreea.proiectjavafacultate.models.Model;

public class ModelAutumn extends Model {
    public void calcBirthday() {
        super.setBirthday(super.getWeight());
    }

}
