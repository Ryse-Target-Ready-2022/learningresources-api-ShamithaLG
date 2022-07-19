package com.tgt.rysetii.learningresourcesapi;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.repository.LearningResourceRepository;
import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LearningresourcesApiApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(LearningresourcesApiApplication.class, args);
    }

    @Autowired
    LearningResourceService learningResourceService;

    @Override
    public void run(String... args) throws Exception{
        List<LearningResource> l =learningResourceService.getLearningResources();
        learningResourceService.saveLearningResources(l);
    }


}