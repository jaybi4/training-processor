package com.jroc.trainingprocessor.util.spel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public final class HelperMethods implements SpELEvaluator.MethodRegistry {

  private static final Map<String, String> replacements = Replacements.getReplacements();

  public static String currentDate(String dateFormat) {
    return LocalDate.now().format(DateTimeFormatter.ofPattern(dateFormat));
  }

  public static String currentDateMinusYears(int years, String dateFormat) {
    return LocalDate.now().minusYears(years).format(DateTimeFormatter.ofPattern(dateFormat));
  }

  public static String replace(String stringToReplace) {
    return replacements.get(stringToReplace);
  }

  public static double sum(List<Double> doubles) {
    return doubles.stream().reduce(Double::sum).orElseThrow();
  }

  public static int avg(List<Short> shorts) {
    int sum = shorts.stream().map(Short::intValue).reduce(Integer::sum).orElseThrow();
    return sum / shorts.size();
  }

}
