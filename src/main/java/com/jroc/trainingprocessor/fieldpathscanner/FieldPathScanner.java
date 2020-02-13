package com.jroc.trainingprocessor.fieldpathscanner;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.asm.AnnotationVisitor;
import org.springframework.asm.Attribute;
import org.springframework.asm.ClassVisitor;
import org.springframework.asm.FieldVisitor;
import org.springframework.asm.MethodVisitor;
import org.springframework.asm.SpringAsmInfo;

public class FieldPathScanner extends ClassVisitor {

  public static final String PRIMITIVE = "primitive";

  private String absolutePath = "";
  private Map<String, Object> outputMap;
  private Set<String> visitedClasses = new LinkedHashSet<>();

  public FieldPathScanner() {
    super(SpringAsmInfo.ASM_VERSION);
  }

  public FieldPathScanner(String absolutePath, Set<String> visitedClasses,
      Map<String, Object> outputMap) {
    super(SpringAsmInfo.ASM_VERSION);
    this.absolutePath = absolutePath;
    this.visitedClasses.addAll(visitedClasses);
    this.outputMap = outputMap;
  }

  public FieldPathScanner(Map<String, Object> outputMap) {
    super(SpringAsmInfo.ASM_VERSION);
    this.outputMap = outputMap;
  }

  public String getLastVisitedClass() {
    return visitedClasses.stream().reduce((first, second) -> second).orElse("");
  }

  /**
   * Called when a class is visited. This is the method called first
   */
  @Override
  public void visit(int version, int access, String name,
      String signature, String superName, String[] interfaces) {
    this.visitedClasses.add(name);
    super.visit(version, access, name, signature, superName, interfaces);
  }

  /**
   * Invoked only when the class being visited is an inner class
   */
  @Override
  public void visitOuterClass(String owner, String name, String desc) {
    super.visitOuterClass(owner, name, desc);
  }

  /**
   * Invoked when a class level annotation is encountered
   */
  @Override
  public AnnotationVisitor visitAnnotation(String desc,
      boolean visible) {
    return super.visitAnnotation(desc, visible);
  }

  /**
   * When a class attribute is encountered
   */
  @Override
  public void visitAttribute(Attribute attr) {
    super.visitAttribute(attr);
  }

  /**
   * When an inner class is encountered
   */
  @Override
  public void visitInnerClass(String name, String outerName,
      String innerName, int access) {
    super.visitInnerClass(name, outerName, innerName, access);
  }

  /**
   * When a field is encountered
   */
  @Override
  public FieldVisitor visitField(int access, String name,
      String desc, String signature, Object value) {
    return new FieldAnnotationVisitor(name, desc, signature, this.absolutePath, this.outputMap,
        this.visitedClasses);
  }


  @Override
  public void visitEnd() {
    super.visitEnd();
  }

  /**
   * When a method is encountered
   */
  @Override
  public MethodVisitor visitMethod(int access, String name,
      String desc, String signature, String[] exceptions) {
    return super.visitMethod(access, name, desc, signature, exceptions);
  }

  /**
   * When the optional source is encountered
   */
  @Override
  public void visitSource(String source, String debug) {
    super.visitSource(source, debug);
  }

  public static String cleanClassDescription(String classDescription) {
    String result = "";
    String pattern = "(\\[?)([BCDFIJLSVZ].*)";
    if (classDescription != null && classDescription.matches(pattern)) {
      result = classDescription.replaceAll(pattern, "$2");
      if (result.startsWith("L")) {
        result = result.substring(1, classDescription.length() - 1);
      } else {
        result = PRIMITIVE;
      }
    }
    return result;
  }
}
