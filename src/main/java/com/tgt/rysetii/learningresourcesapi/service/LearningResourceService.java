package com.tgt.rysetii.learningresourcesapi.service;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResourceStatus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LearningResourceService {

    // Load data form LearningResources.csv file
    public List<LearningResource> getLearningResources() {
        File learningResourcesFile = new File("LearningResources.csv");
        List<LearningResource> learningResources = loadLearningResourceFromCsv(learningResourcesFile);
        return learningResources;
    }
    private List<LearningResource> loadLearningResourceFromCsv(File csvFile){
        List<LearningResource> learningResources = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(csvFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String string = bufferedReader.readLine();
            while(string!= null){
                String[] attributes = string.split(",");
                LearningResource learningResource = createLR(attributes);
                learningResources.add(learningResource);
                string = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return learningResources;
    }
    private LearningResource createLR(String[] attributes){
        Integer id = Integer.parseInt(attributes[0].replaceAll("\\D+", ""));
        String productName = attributes[1];
        Double costPrice = Double.parseDouble(attributes[2]);
        Double sellingPrice = Double.parseDouble(attributes[3]);
        LearningResourceStatus productStatus = LearningResourceStatus.valueOf(attributes[4]);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate createdDate = LocalDate.parse(attributes[5], dateFormatter);
        LocalDate publishedDate = LocalDate.parse(attributes[6], dateFormatter);
        LocalDate retiredDate = LocalDate.parse(attributes[7], dateFormatter);

        LearningResource lR = new LearningResource(
                id, productName, costPrice, sellingPrice, productStatus, createdDate, publishedDate, retiredDate
        );
        return lR;
    }


}
