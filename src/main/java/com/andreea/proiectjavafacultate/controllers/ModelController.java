package com.andreea.proiectjavafacultate.controllers;


import com.andreea.proiectjavafacultate.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.andreea.proiectjavafacultate.services.ModelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ModelController {
    @Autowired
    private ModelService modelService;

    @RequestMapping(value = "/models")
    public List<Model> getAllModels()
    {
        return modelService.getAllModels();
    }

    @RequestMapping(value = "/model/{id}")
    public Model getModelById(@PathVariable int id)
    {
        return modelService.getModel(id);
    }

    @RequestMapping(value = "/addModel", method = RequestMethod.POST)
    public boolean addModel(@RequestBody Model m)
    {
        return modelService.addModel(m);
    }

    @RequestMapping(value = "/getModelId/{name}")
    public int getEventsById(@PathVariable String name)
    {
        return modelService.getModelId(name);
    }

    @RequestMapping(value = "/updateHeight", method = RequestMethod.POST,  consumes = "application/json")
    public boolean updateHeight(@RequestBody Map<String, Integer> json)
    {
        System.out.println("S-A APELAT RUTA");
        int modelId = json.get("modelId");
        int height = json.get("height");

        return modelService.updateHeight(modelId, height);
    }

    @RequestMapping(value = "/updateWeight", method = RequestMethod.POST,  consumes = "application/json")
    public boolean updateWeight(@RequestBody Map<String, Integer> json)
    {
        System.out.println("S-A APELAT RUTA");
        int modelId = json.get("modelId");
        int weight = json.get("weight");

        return modelService.updateWeight(modelId, weight);
    }

    @RequestMapping(value = "/updateBirthday", method = RequestMethod.POST,  consumes = "application/json")
    public boolean updateBirthday(@RequestBody Map<String, Integer> json)
    {
        System.out.println("S-A APELAT RUTA");
        int modelId = json.get("modelId");
        int birthday = json.get("birthday");

        return modelService.updateBirthday(modelId, birthday);
    }

    @RequestMapping(value = "/enrollModel", method = RequestMethod.POST)
    public boolean enrollModel(@RequestBody Map<String, Integer> json)
    {
        System.out.println("SE APELEAZA ENROLL");
        int modelId = json.get("modelId");
        int eventId = json.get("eventId");
        System.out.println(modelId);
        System.out.println(eventId);
        return modelService.enrollToEvent(modelId, eventId);
    }

    @RequestMapping(value = "/delModel/{id}", method = RequestMethod.POST)
    public boolean deleteModel(@PathVariable int id)
    {
        return modelService.deleteModel(id);
    }

}
