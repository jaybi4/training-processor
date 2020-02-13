package com.jroc.trainingprocessor.fieldpathscanner;

import com.jroc.trainingprocessor.annotation.FieldExpression;
import com.jroc.trainingprocessor.annotation.FieldMapping;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.asm.AnnotationVisitor;
import org.springframework.asm.SpringAsmInfo;

public class FieldMappingAnnotationVisitor extends AnnotationVisitor {
  private static final Logger LOG = LogManager.getLogger();

  private static final String VALUE = "value";
  private static final String EXPRESSION = "expression";
  private static final String IS_AUXILIARY = "isAuxiliary";
  private String currentAnnotation;
  private String absolutePath;
  private Map<String, Object> outputMap;
  private String currentAnnotationValue = "";
  private String element;
  private String parentClass;

  public FieldMappingAnnotationVisitor() {
    super(SpringAsmInfo.ASM_VERSION);
  }

  public FieldMappingAnnotationVisitor(String currentAnnotation, String absolutePath,
      Map<String, Object> outputMap, String element, String parentClass) {
    super(SpringAsmInfo.ASM_VERSION);
    this.currentAnnotation = FieldPathScanner.cleanClassDescription(currentAnnotation);
    this.absolutePath = absolutePath;
    this.outputMap = outputMap;
    this.element = element;
    this.parentClass = parentClass;
  }

  @Override
  public void visit(String name, Object value) {
    if (currentAnnotation.equals(FieldMapping.class.getCanonicalName().replace(".", "/"))) {
      if (name.equals(VALUE)) {
        this.currentAnnotationValue = value.toString();
        if (this.absolutePath.endsWith(".![]")) { // undo collection projection if at the end
          this.absolutePath = this.absolutePath.substring(0, this.absolutePath.length() - 4);
        }
        outputMap.put(currentAnnotationValue,
            new FieldMappingObject(currentAnnotationValue, this.absolutePath));
      } else if (name.equals(EXPRESSION)) {
        FieldMappingObject fieldMapping = (FieldMappingObject) outputMap
            .get(currentAnnotationValue);
        fieldMapping.setSpelExpr(FieldPathBuilder
            .computePath(this.absolutePath, this.currentAnnotation, value.toString()));
      } else if (name.equals(IS_AUXILIARY)) {
        FieldMappingObject fieldMapping = (FieldMappingObject) outputMap
            .get(currentAnnotationValue);
        fieldMapping.setAuxiliary(Boolean.parseBoolean(value.toString()));
      }
    } else if (currentAnnotation.equals(
        FieldExpression.class.getCanonicalName().replace(".", "/"))) {
      if (name.equals(VALUE)) {
        this.currentAnnotationValue = value.toString();
      } else if (name.equals(EXPRESSION)) {
        outputMap.put(currentAnnotationValue,
            new FieldMappingObject(currentAnnotationValue, value.toString()));
      } else if (name.equals(IS_AUXILIARY)) {
        FieldMappingObject fieldMapping = (FieldMappingObject) outputMap
            .get(currentAnnotationValue);
        fieldMapping.setAuxiliary(Boolean.parseBoolean(value.toString()));
      }
    }
    super.visit(name, value);
  }

  @Override
  public AnnotationVisitor visitArray(String name) {
    try {
      if (currentAnnotation.replace("/", ".")
          .equals(FieldMapping.FieldMappings.class.getTypeName())) {
        FieldMapping[] annotations = Class.forName(parentClass.replace("/", "."))
            .getDeclaredField(element)
            .getAnnotationsByType(FieldMapping.class);
        for (FieldMapping e : annotations) {
          StringBuilder sb = new StringBuilder(this.absolutePath);
          if (this.absolutePath.endsWith(".![]")) { // undo collection projection because at the end
            sb.delete(this.absolutePath.length() - 4, this.absolutePath.length());
          }
          if (!this.absolutePath.isEmpty() && !e.expression().startsWith(".") && !e.expression()
              .startsWith(" ")) {
            sb.append(".");
          }
          outputMap.put(e.value(),
              new FieldMappingObject(e.value(), sb.append(e.expression()).toString(),
                  e.isAuxiliary()));
        }
      } else if (currentAnnotation.replace("/", ".")
          .equals(FieldExpression.FieldExpressions.class.getTypeName())) {
        FieldExpression[] annotations = Class.forName(parentClass.replace("/", "."))
            .getDeclaredField(element)
            .getAnnotationsByType(FieldExpression.class);
        for (FieldExpression e : annotations) {
          outputMap
              .put(e.value(), new FieldMappingObject(e.value(), e.expression(), e.isAuxiliary()));
        }
      }
    } catch (ClassNotFoundException | NoSuchFieldException e) {
      LOG.error(e.getMessage());
    }
    return super.visitArray(name);
  }
}
