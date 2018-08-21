package com.pkuch.service;

import java.util.List;
import java.util.function.IntBinaryOperator;

public class CalculatorServiceImpl implements CalculatorService {
    private IntBinaryOperator add = (x, y) -> x + y;
    private IntBinaryOperator multiply = (x, y) -> x * y;

    @Override
    public Integer add(List<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).reduce(0, add);
    }

    @Override
    public Integer multiply(List<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).reduce(1, multiply);
    }
}
