package com.jroc.trainingprocessor.spring.config;

import com.jroc.trainingprocessor.fieldpathscanner.FieldMapGenerator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class LoadResourcesConfig {

  @Bean
  public Map<String, Object> resourceMap() throws IOException, ClassNotFoundException {
    return new ResourceMapReader(FieldMapGenerator.MAPPINGS_FILENAME).getMap();
  }

  private static class ResourceMapReader {

    private Map<String, Object> map;

    public ResourceMapReader(String path) throws IOException, ClassNotFoundException {
      ResourceLoader resourceLoader = new DefaultResourceLoader();
      Resource resource = resourceLoader.getResource(path);
      this.map = asMap(resource);
    }

    private Map<String, Object> asMap(Resource resource)
        throws IOException, ClassNotFoundException {
      ObjectInputStream objectInputStream = new ObjectInputStream(resource.getInputStream());
      @SuppressWarnings("unchecked")
      Map<String, Object> objectMap = (Map<String, Object>) objectInputStream.readObject();
      return objectMap;
    }

    public Map<String, Object> getMap() {
      return this.map;
    }
  }
}
