package com.jroc.trainingprocessor.spring.services;

import com.jroc.trainingprocessor.fieldpathscanner.FieldMappingObject;
import com.jroc.trainingprocessor.model.Workout;
import com.jroc.trainingprocessor.model.WorkoutRegistry;
import com.jroc.trainingprocessor.model.trainingcenterdatabase.ActivityT;
import com.jroc.trainingprocessor.model.trainingcenterdatabase.TrainingCenterDatabaseT;
import com.jroc.trainingprocessor.util.spel.HelperMethods;
import com.jroc.trainingprocessor.util.spel.SpELEvaluator;
import java.time.Duration;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.expression.EvaluationContext;
import org.springframework.stereotype.Service;

@Service
public class TrainingProcessorServiceImpl implements TrainingProcessorService {

  @Resource
  private Map<String, Object> resourceMap;

  @Override
  public WorkoutRegistry processTrainingCenterDatabase(
      TrainingCenterDatabaseT trainingCenterDatabaseT) {
    WorkoutRegistry workoutRegistry = new WorkoutRegistry();

    for (ActivityT activityT : trainingCenterDatabaseT.getActivities().getActivity()) {
      EvaluationContext context = SpELEvaluator.getContext(activityT, new HelperMethods());

      Workout workout = new Workout();
      workout.setDate(SpELEvaluator.parseExpression(((FieldMappingObject) resourceMap.get("date")).getSpelExpr(), resourceMap, context).toString());
      Double time = (Double) SpELEvaluator.parseExpression(((FieldMappingObject) resourceMap.get("time")).getSpelExpr(), resourceMap, context);
      workout.setTime(Duration.ofSeconds(time.longValue()));
      workout.setDistance((Double) SpELEvaluator.parseExpression(((FieldMappingObject) resourceMap.get("distance")).getSpelExpr(), resourceMap, context));
      workout.setAvgHeartRate((Integer) SpELEvaluator.parseExpression(((FieldMappingObject) resourceMap.get("avgHeartRate")).getSpelExpr(), resourceMap, context));
      workoutRegistry.addWorkout(workout);
    }

    return workoutRegistry;
  }
}
