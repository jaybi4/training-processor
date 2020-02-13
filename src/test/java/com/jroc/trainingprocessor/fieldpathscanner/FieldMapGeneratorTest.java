package com.jroc.trainingprocessor.fieldpathscanner;

import static org.junit.Assert.assertNotNull;

import com.jroc.trainingprocessor.spring.config.LoadResourcesConfig;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = LoadResourcesConfig.class)
public class FieldMapGeneratorTest {

  private static final Logger LOG = LogManager.getLogger();

  @Resource
  private Map<String, Object> resourceMap;

  @Test
  public void fieldMapGeneratorTest() {
    resourceMap.forEach((s, o) -> LOG.info(String.format("%s=%s", s, o)));
    assertNotNull(resourceMap);
  }

}
