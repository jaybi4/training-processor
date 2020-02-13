package com.jroc.trainingprocessor.fieldpathscanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class FieldPathBuilder {

  public static final Pattern COLLECTION_PROJECTION_PATTERN = Pattern.compile("\\.\\!\\[(.*)\\]");
  public static final String LIST = "java/util/List";
  public static final String XML_DATE = "javax/xml/datatype/XMLGregorianCalendar";

  private FieldPathBuilder() {
    throw new UnsupportedOperationException();
  }

  public static String computePath(String path, String classDescription, String elementName) {
    Matcher matcher = COLLECTION_PROJECTION_PATTERN.matcher(path);
    StringBuilder sb = new StringBuilder();
    if (matcher.find()) {
      String innerPath = matcher.group(1);
      matcher.appendReplacement(sb, Matcher
          .quoteReplacement(".![" + computePath(innerPath, classDescription, elementName)
              + "]")); // avoid computePath cycle
      return sb.toString();
    }

    return sb.append(appendPath(path, classDescription, elementName)).toString();
  }

  public static String appendPath(String absolutePath, String classDescription,
      String elementName) {
    String className = FieldPathScanner.cleanClassDescription(classDescription);

    StringBuilder sb = new StringBuilder(absolutePath);
    if (!absolutePath.isEmpty() && !elementName.startsWith(".") && !elementName.startsWith(" ")) {
      sb.append(".");
    }

    sb.append(elementName);

    if (className.startsWith(LIST)) {
      sb.append(".![]");
    } else if (className.equals(XML_DATE)) {
      sb.append(".toString()");
    } else if (isEnum(className)) {
      sb.append(".value()"); // value() used because Enum value property not visible
    }

    return sb.toString();
  }

  private static boolean isEnum(String className) {
    try {
      return Class.forName(className.replace("/", ".")).isEnum();
    } catch (ClassNotFoundException e) {
      return false;
    }
  }
}
