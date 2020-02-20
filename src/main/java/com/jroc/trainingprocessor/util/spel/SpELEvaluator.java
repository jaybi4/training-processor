package com.jroc.trainingprocessor.util.spel;

import com.jroc.trainingprocessor.fieldpathscanner.FieldMappingObject;
import java.lang.reflect.Method;
import java.util.List;
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

  public interface MethodRegistry {

    default List<Method> methodsToRegister() {
      return List.of(this.getClass().getDeclaredMethods());
    }
  }

  private static final Logger LOG = LogManager.getLogger();

  private SpELEvaluator() {
    throw new UnsupportedOperationException();
  }

  public static EvaluationContext getContext(Object contextObject, MethodRegistry methodRegistry) {
    EvaluationContext context = new StandardEvaluationContext(contextObject);
    methodRegistry.methodsToRegister()
        .forEach(method -> context.setVariable(method.getName(), method));
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

}
