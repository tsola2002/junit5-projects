package org.tsola2002.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  void addTest() {
    // Given
    Calculator calculator = new Calculator();

    // When
    double result = calculator.add(10, 50);

    // Then
    assertEquals(60, 60);
  }
}