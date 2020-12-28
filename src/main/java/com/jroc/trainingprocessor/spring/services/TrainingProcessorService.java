package com.jroc.trainingprocessor.spring.services;

import com.jroc.trainingprocessor.model.WorkoutRegistry;
import com.jroc.trainingprocessor.model.trainingcenterdatabase.TrainingCenterDatabaseT;

public interface TrainingProcessorService {

  WorkoutRegistry processTrainingCenterDatabase(TrainingCenterDatabaseT trainingCenterDatabaseT);

}
