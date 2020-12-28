package com.jroc.trainingprocessor.model;

import java.util.ArrayList;
import java.util.List;

public class WorkoutRegistry {

  private List<Workout> workouts = new ArrayList<>();

  public void addWorkout(Workout workout) {
    this.workouts.add(workout);
  }

  public void removeWorkout(Workout workout) {
    this.workouts.remove(workout);
  }

}
