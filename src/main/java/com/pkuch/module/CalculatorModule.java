package com.pkuch.module;

import com.google.inject.AbstractModule;
import com.pkuch.service.CalculatorService;
import com.pkuch.service.CalculatorServiceImpl;

public class CalculatorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CalculatorService.class).toInstance(new CalculatorServiceImpl());
    }
}
