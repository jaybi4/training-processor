package com.jroc.trainingprocessor.fieldpathscanner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.asm.ClassReader;

public class FieldMapGenerator {

  private static final Logger LOG = LogManager.getLogger();

  public static final String ARGS_PREFIX = "-";
  public static final String ARGS_INPUT_CLASS = "-c";
  public static final String ARGS_OUTPUT_DIR = "-d";
  public static final String MAPPINGS_FILENAME = "fieldMappings.map";

  public static void main(String[] args) throws IOException {

    Map<String, String> argsMap = parseCmdArgs(args);

    ClassReader classReader = new ClassReader(argsMap.get(ARGS_INPUT_CLASS));

    HashMap<String, Object> outputMap = new HashMap<>();
    classReader.accept(new FieldPathScanner(outputMap), 0);

    File file = new File(argsMap.get(ARGS_OUTPUT_DIR));
    if (!file.exists()) {
      if (file.mkdir()) {
        LOG.info("Directory created");
      } else {
        LOG.error("Could not create directory");
        return;
      }
    }

    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(
        Paths.get("target/generated-mapping-files", MAPPINGS_FILENAME).toString()))) {
      objectOutputStream.writeObject(outputMap);
    }

  }

  private static Map<String, String> parseCmdArgs(String[] args) {
    String inputClassName = "";
    String outputDir = "";
    int i = 0;

    while (i < args.length && args[i].startsWith(ARGS_PREFIX)) {
      if (args[i].equals(ARGS_INPUT_CLASS)) {
        i++;
        inputClassName = args[i];
      } else if (args[i].equals(ARGS_OUTPUT_DIR)) {
        i++;
        outputDir = args[i];
      }
      i++;
    }

    if (inputClassName.isEmpty() || outputDir.isEmpty()) {
      LOG.warn("Usage: FieldMapGenerator -d outputDirectory -c inputClassName");
    } else {
      return Map.of(ARGS_OUTPUT_DIR, outputDir, ARGS_INPUT_CLASS, inputClassName);
    }
    return Map.of();
  }
}
