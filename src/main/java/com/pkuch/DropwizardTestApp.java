package com.pkuch;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pkuch.health.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.pkuch.module.CalculatorModule;
import com.pkuch.resourses.MultiplyResource;
import com.pkuch.resourses.AddResource;
import com.pkuch.service.CalculatorService;

public class DropwizardTestApp extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new DropwizardTestApp().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard test";
    }

    public void initialize(Bootstrap<AppConfiguration> bootstrap) {

    }

    public void run(AppConfiguration appConfiguration, Environment environment) throws Exception {
        Injector injector = Guice.createInjector(new CalculatorModule());
        final AddResource addResource = new AddResource(
                appConfiguration.getAddTemplate(),
                appConfiguration.getDefaultAnswer(),
                injector.getInstance(CalculatorService.class)
        );
        final MultiplyResource multiplyResource = new MultiplyResource(
                appConfiguration.getMultiplyTemplate(),
                appConfiguration.getDefaultAnswer(),
                injector.getInstance(CalculatorService.class)
        );
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(appConfiguration.getAddTemplate());
        environment.jersey().register(addResource);
        environment.jersey().register(multiplyResource);
        environment.healthChecks().register("template", healthCheck);
    }
}
