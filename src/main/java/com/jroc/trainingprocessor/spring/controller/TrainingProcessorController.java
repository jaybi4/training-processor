package com.jroc.trainingprocessor.spring.controller;

import com.jroc.trainingprocessor.model.WorkoutRegistry;
import com.jroc.trainingprocessor.model.trainingcenterdatabase.TrainingCenterDatabaseT;
import com.jroc.trainingprocessor.spring.services.TrainingProcessorService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingProcessorController {

  private TrainingProcessorService trainingProcessorService;

  public TrainingProcessorController(TrainingProcessorService trainingProcessorService) {
    this.trainingProcessorService = trainingProcessorService;
  }

  @GetMapping("/status")
  public String status() {
    return "Training Processor Service running...";
  }

  @PostMapping(value = "/process", consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WorkoutRegistry processOrigoRequest(@Validated @RequestBody TrainingCenterDatabaseT trainingCenterRequest) {
    return trainingProcessorService.processTrainingCenterDatabase(trainingCenterRequest);
  }

}
