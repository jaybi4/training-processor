package com.jroc.trainingprocessor.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingProcessorController {

  @GetMapping("/status")
  public String status() {
    return "Training Processor Service running...";
  }

}
