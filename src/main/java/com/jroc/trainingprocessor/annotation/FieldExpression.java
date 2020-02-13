package com.jroc.trainingprocessor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(FieldExpression.FieldExpressions.class)
public @interface FieldExpression {

  String value();

  String expression();

  boolean isAuxiliary() default false;

  @Target({ElementType.FIELD})
  @Retention(RetentionPolicy.RUNTIME)
  @interface FieldExpressions {

    FieldExpression[] value();
  }
}
