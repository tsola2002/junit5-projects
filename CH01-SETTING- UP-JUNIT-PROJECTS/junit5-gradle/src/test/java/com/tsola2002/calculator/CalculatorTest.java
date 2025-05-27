package com.tsola2002.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  public void addTest(){
    Calculator calculator = new Calculator();

    // when
    double result = calculator.add(10, 50);

    // then
    assertEquals(60, result);
  }

}
