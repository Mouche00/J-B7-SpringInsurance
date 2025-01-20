package com.insurance.strategies;

public interface InsuranceCalculator<T> {
    double calculate(T insurance);
}
