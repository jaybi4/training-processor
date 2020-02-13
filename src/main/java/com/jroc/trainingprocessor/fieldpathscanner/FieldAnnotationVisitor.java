package com.jroc.trainingprocessor.fieldpathscanner;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.asm.AnnotationVisitor;
import org.springframework.asm.ClassReader;
import org.springframework.asm.FieldVisitor;
import org.springframework.asm.SpringAsmInfo;

public class FieldAnnotationVisitor extends FieldVisitor {

  private static final Logger LOG = LogManager.getLogger();

  private String name;
  private String description;
  private String signature;
  private String absolutePath = "";
  private Map<String, Object> outputMap;
  private String parentClass = "";
  private Set<String> visitedClasses = new HashSet<>();

  public FieldAnnotationVisitor() {
    super(SpringAsmInfo.ASM_VERSION);
  }

  public FieldAnnotationVisitor(String name, String desc, String signature, String absolutePath,
      Map<String, Object> outputMap, Set<String> visitedClasses) {
    super(SpringAsmInfo.ASM_VERSION);
    this.name = name;
    this.description = desc;
    this.signature = signature;
    this.outputMap = outputMap;
    this.parentClass = visitedClasses.stream().reduce((first, second) -> second).orElse("");
    this.visitedClasses.addAll(visitedClasses);
    this.absolutePath = FieldPathBuilder.computePath(absolutePath, desc, name);
  }

  @Override
  public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
    return new FieldMappingAnnotationVisitor(descriptor, this.absolutePath, this.outputMap,
        this.name, this.parentClass);
  }

  @Override
  public void visitEnd() {
    try {
      recursiveReader();
    } catch (IOException e) {
      LOG.error(e.getMessage());
    }
    super.visitEnd();
  }

  private void recursiveReader() throws IOException {
    String className = FieldPathScanner.cleanClassDescription(this.description);
    String pattern = "(Ljava/util/List<)(.*)(>;)";

    if (!className.startsWith("java/") && !className.equals(FieldPathScanner.PRIMITIVE) && !isEnum(
        className) && !visitedClasses.contains(className)) {
      new ClassReader(className)
          .accept(new FieldPathScanner(this.absolutePath, this.visitedClasses, this.outputMap), 0);
    } else if (this.signature != null && this.signature.matches(pattern) && !visitedClasses
        .contains(
            FieldPathScanner.cleanClassDescription(this.signature.replaceAll(pattern, "$2")))) {
      new ClassReader(
          FieldPathScanner.cleanClassDescription(this.signature.replaceAll(pattern, "$2")))
          .accept(new FieldPathScanner(this.absolutePath, this.visitedClasses, this.outputMap), 0);
    }
  }

  private boolean isEnum(String className) {
    try {
      return Class.forName(className.replace("/", ".")).isEnum();
    } catch (ClassNotFoundException e) {
      return false;
    }
  }
}
