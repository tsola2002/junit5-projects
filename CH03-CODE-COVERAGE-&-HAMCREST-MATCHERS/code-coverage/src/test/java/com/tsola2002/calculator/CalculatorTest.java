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



  @Test
  void subtractTest() {
    Calculator calc = new Calculator();
    assertEquals(1, calc.subtract(2, 1));
  }

  @Test
  void divideTest() {
    Calculator calc = new Calculator();
    assertEquals(2, calc.divide(10, 5));
  }

  @Test
  void multiplyTest() {
    Calculator calc = new Calculator();
    assertEquals(4, calc.multiply(2, 2));
  }
}