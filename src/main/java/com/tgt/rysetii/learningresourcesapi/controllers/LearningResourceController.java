package com.tgt.rysetii.learningresourcesapi.controllers;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/learningresources")
public class LearningResourceController {

    @Autowired
    private final LearningResourceService learningResourceService;

    public LearningResourceController(LearningResourceService learningResourceService) {
        this.learningResourceService = learningResourceService;
    }

    @GetMapping("/")
    public List<LearningResource> getAllLearningResources(){
        return learningResourceService.getLearningResources();
    }


    @PostMapping(value = "/", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLearningResources(@RequestBody List<LearningResource> learningResources){
        learningResourceService.saveLearningResources(learningResources);
    }

    @DeleteMapping(value = "/learningresources/{Id}")
    public void deleteLearningResource(@PathVariable int Id){
        learningResourceService.deleteLearningResourceById(Id);
    }
}
