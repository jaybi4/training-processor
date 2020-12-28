package com.jroc.trainingprocessor.model;

import java.time.Duration;
import java.util.Objects;

public class Workout {

  private String date;
  private Duration time;
  private Double distance;
  private int avgHeartRate;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Duration getTime() {
    return time;
  }

  public void setTime(Duration time) {
    this.time = time;
  }

  public Double getDistance() {
    return distance;
  }

  public void setDistance(Double distance) {
    this.distance = distance;
  }

  public int getAvgHeartRate() {
    return avgHeartRate;
  }

  public void setAvgHeartRate(int avgHeartRate) {
    this.avgHeartRate = avgHeartRate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Workout workout = (Workout) o;
    return date.equals(workout.date) && time.equals(workout.time) && distance
        .equals(workout.distance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, time, distance);
  }
}
