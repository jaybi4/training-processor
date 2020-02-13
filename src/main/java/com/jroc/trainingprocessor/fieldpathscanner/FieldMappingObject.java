package com.jroc.trainingprocessor.fieldpathscanner;

import java.io.Serializable;
import java.util.Objects;

public class FieldMappingObject implements Serializable {

  private String fieldId;
  private String spelExpr;
  private boolean isAuxiliary = false;

  public FieldMappingObject(String fieldId, String spelExpr) {
    this.fieldId = fieldId;
    this.spelExpr = spelExpr;
  }

  public FieldMappingObject(String fieldId, String spelExpr, boolean isAuxiliary) {
    this.fieldId = fieldId;
    this.spelExpr = spelExpr;
    this.isAuxiliary = isAuxiliary;
  }

  public String getFieldId() {
    return fieldId;
  }

  public void setFieldId(String fieldId) {
    this.fieldId = fieldId;
  }

  public String getSpelExpr() {
    return spelExpr;
  }

  public void setSpelExpr(String spelExpr) {
    this.spelExpr = spelExpr;
  }

  public boolean isAuxiliary() {
    return isAuxiliary;
  }

  public void setAuxiliary(boolean auxiliary) {
    isAuxiliary = auxiliary;
  }

  @Override
  public String toString() {
    return "FieldMappingObject{" +
        "fieldId='" + fieldId + '\'' +
        ", spelExpr='" + spelExpr + '\'' +
        ", isAuxiliary=" + isAuxiliary +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    FieldMappingObject that = (FieldMappingObject) o;

    if (isAuxiliary != that.isAuxiliary) {
      return false;
    }
    if (!fieldId.equals(that.fieldId)) {
      return false;
    }
    return Objects.equals(spelExpr, that.spelExpr);
  }

  @Override
  public int hashCode() {
    int result = fieldId.hashCode();
    result = 31 * result + (spelExpr != null ? spelExpr.hashCode() : 0);
    result = 31 * result + (isAuxiliary ? 1 : 0);
    return result;
  }
}
