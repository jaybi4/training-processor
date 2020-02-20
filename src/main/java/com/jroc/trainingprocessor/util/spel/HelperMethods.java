package com.jroc.trainingprocessor.util.spel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

}
