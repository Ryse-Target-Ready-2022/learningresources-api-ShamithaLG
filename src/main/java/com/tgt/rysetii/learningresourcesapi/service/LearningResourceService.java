package com.tgt.rysetii.learningresourcesapi.service;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResourceStatus;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

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



    //next
    //save data to .csv file
    public void saveLearningResources(List<LearningResource> learningResources){
        populateLearningResourcesToCsv(learningResources);
    }

    private void populateLearningResourcesToCsv(List<LearningResource> learningResources){
        final String csvDelimiter = ",";

        try {
            File learningResourcesFile = new File("LearningResources.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(learningResourcesFile.getName(), true));
            for (LearningResource learningResource : learningResources) {
                bufferedWriter.newLine();
                StringBuffer l = new StringBuffer();
                l.append(learningResource.getId());
                l.append(csvDelimiter);
                l.append(learningResource.getProductName());
                l.append(csvDelimiter);
                l.append(learningResource.getCostPrice());
                l.append(csvDelimiter);
                l.append(learningResource.getSellingPrice());
                l.append(csvDelimiter);
                l.append(learningResource.getProductStatus());
                l.append(csvDelimiter);
                l.append(learningResource.getCreatedDate());
                l.append(csvDelimiter);
                l.append(learningResource.getPublishedDate());
                l.append(csvDelimiter);
                l.append(learningResource.getRetiredDate());
                bufferedWriter.write(l.toString());
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

}
