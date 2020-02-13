package com.jroc.trainingprocessor.fieldpathscanner;

import com.jroc.trainingprocessor.annotation.FieldMapping;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.asm.ClassReader;

import static org.junit.Assert.*;

public class FieldPathScannerTest {

  private static final Logger LOG = LogManager.getLogger();

  @Test
  public void fieldPathScannerTest() throws IOException {
    ClassReader classReader = new ClassReader(AnnotationsTestClass.class.getCanonicalName());

    Map<String, Object> outputMap = new HashMap<>();
    classReader.accept(new FieldPathScanner(outputMap), 0);
    outputMap.forEach((s, o) -> LOG.info(String.format("%s=%s", s, o)));

    Optional<FieldMappingObject> fieldMappingObject = Optional.empty();
    if (outputMap.get("ThisIsFieldA") instanceof FieldMappingObject) {
      fieldMappingObject = Optional.of((FieldMappingObject) outputMap.get("ThisIsFieldA"));
    }

    fieldMappingObject.ifPresentOrElse(
        fieldMappingObject1 -> assertEquals("a", fieldMappingObject1.getSpelExpr()),
        Assert::fail);
  }

}

class AnnotationsTestClass {

  @FieldMapping("ThisIsFieldA")
  private String a;
}
