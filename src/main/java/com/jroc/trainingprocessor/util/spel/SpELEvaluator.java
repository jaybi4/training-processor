package com.jroc.trainingprocessor.util.spel;

import com.jroc.trainingprocessor.fieldpathscanner.FieldMappingObject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public final class SpELEvaluator {

  private static final Logger LOG = LogManager.getLogger();

  private static final Map<String, String> replacements = Replacements.getReplacements();

  private SpELEvaluator() {
    throw new UnsupportedOperationException();
  }

  public static EvaluationContext getContext(Object contextObject) {
    EvaluationContext context = new StandardEvaluationContext(contextObject);
    try {
      context.setVariable("currentDate",
          SpELEvaluator.class.getDeclaredMethod("currentDate", String.class));
      context.setVariable("currentDateMinusYears",
          SpELEvaluator.class.getDeclaredMethod("currentDateMinusYears", int.class, String.class));
      context
          .setVariable("replace", SpELEvaluator.class.getDeclaredMethod("replace", String.class));
    } catch (NoSuchMethodException e) {
      LOG.error(e.getMessage());
    }
    return context;
  }

  public static Object parseExpression(String expressionString, Map<String, Object> resourceMap,
      EvaluationContext context) {
    Pattern pattern = Pattern.compile("#\\{(.*?)\\}");
    Matcher matcher = pattern.matcher(expressionString);
    StringBuilder sb = new StringBuilder();
    while (matcher.find()) {
      String key = matcher.group(1);
      matcher.appendReplacement(sb,
          Matcher.quoteReplacement(((FieldMappingObject) resourceMap.get(key)).getSpelExpr()));
    }
    matcher.appendTail(sb);
    return Objects.requireNonNull(
        new SpelExpressionParser().parseExpression(sb.toString()).getValue(context));
  }

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
