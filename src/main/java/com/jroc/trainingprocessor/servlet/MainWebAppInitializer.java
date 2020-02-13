package com.jroc.trainingprocessor.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MainWebAppInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.scan("com.jroc.trainingprocessor");

    servletContext.addListener(new ContextLoaderListener(context));

    ServletRegistration.Dynamic dispatcher = servletContext
        .addServlet("mvc", new DispatcherServlet(context));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }
}
