package com.pkuch.service;

import com.google.inject.ImplementedBy;

import java.util.List;

@ImplementedBy(CalculatorServiceImpl.class)
public interface CalculatorService {
    Integer add(List<Integer> values);
    Integer multiply(List<Integer> values);
}
