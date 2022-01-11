package com.andreea.proiectjavafacultate.controllers;

import com.andreea.proiectjavafacultate.models.Designer;
import com.andreea.proiectjavafacultate.services.DesignerService;
import com.andreea.proiectjavafacultate.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DesignerController {
    @Autowired
    private DesignerService designerService;
    @Autowired
    private ModelService modelService;


    @RequestMapping(value = "/designers")
    public List<Designer> getAllDesigner()
    {
        return designerService.getAllDesigners();
    }

    @RequestMapping(value = "/designer/{id}")
    public Designer getDesignerById(@PathVariable int id)
    {
        return designerService.getDesigner(id);
    }

    @RequestMapping(value = "/addDesigner", method = RequestMethod.POST)
    public boolean addDesigner(@RequestBody Designer c)
    {
        return designerService.addDesigner(c);
    }

    @RequestMapping(value = "/addModelToDesigner", method = RequestMethod.POST)
    public boolean enrollModelToDesigner(@RequestBody Map<String, Integer> json)
    {
        System.out.println("SE APELEAZA ENROLL");
        int modelId = json.get("modelId");
        int designerId = json.get("designerId");
        System.out.println(modelId);
        System.out.println(designerId);
        return modelService.enrollToDesigner(modelId, designerId);
    }

    @RequestMapping(value = "/delDesigner/{id}", method = RequestMethod.POST)
    public boolean deleteDesigner(@PathVariable int id)
    {
        return designerService.deleteDesigner(id);
    }

}
