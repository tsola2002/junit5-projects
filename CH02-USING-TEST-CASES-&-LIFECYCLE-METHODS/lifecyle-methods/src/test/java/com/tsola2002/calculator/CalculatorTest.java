package com.tsola2002.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  void addTest() {
    // create object of Calculator class
    Calculator calc = new Calculator();

    //using junit 5 assertEquals method
    assertEquals(2, calc.add(1, 1));
  }

}