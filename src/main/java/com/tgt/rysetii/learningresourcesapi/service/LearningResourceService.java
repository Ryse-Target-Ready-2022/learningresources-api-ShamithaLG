package com.tgt.rysetii.learningresourcesapi.service;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResourceStatus;
import com.tgt.rysetii.learningresourcesapi.repository.LearningResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
@Service
public class LearningResourceService {
    @Autowired
    private LearningResourceRepository lr;


    public LearningResourceService(LearningResourceRepository lr){
        this.lr=lr;
    }
    public void saveLearningResources(List<LearningResource> learningResources){
        for(LearningResource learningResource : learningResources) lr.save(learningResource);

    }



    public List<LearningResource> getLearningResources(){
        return lr.findAll();
    }
    // calculate profit margin
    public List<Double> getProfitMargin(){
        List<LearningResource> learningResources = getLearningResources();

        List<Double> profitMargins = learningResources.stream().map(l -> ((l.getSellingPrice() - l.getCostPrice())/l.getSellingPrice()))
                .collect(toList());

        return profitMargins;
    }


    //sort the learning resources based on profit margin
    public List<LearningResource> sortLearningResources(){
        List<LearningResource> learningResources = getLearningResources();

        learningResources.sort((l1, l2) -> {
            Double profit1 = (l1.getSellingPrice() - l1.getCostPrice())/l1.getSellingPrice();
            Double profit2 = (l2.getSellingPrice() - l2.getCostPrice())/l2.getSellingPrice();

            return profit2.compareTo(profit1) ;
        });

        return learningResources;
    }

    public void deleteLearningResourceById(int learningResourceId) {

        lr.deleteById(learningResourceId);
    }
}
