package com.jroc.trainingprocessor.util.spel;

import java.util.Map;

public final class Replacements {

  private Replacements() {

  }

  /**
   * Map values
   */
  public static Map<String, String> getReplacements() {
    //noinspection RedundantTypeArguments (explicit type arguments speedup compilation and analysis time)
    return Map.<String, String>ofEntries(
        //Gender
        Map.entry("Male", "Male"),
        Map.entry("Female", "Female")
    );
  }
}
