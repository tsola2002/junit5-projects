package com.tsola2002.sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SUTTest {

  private SUT systemUnderTest;
  private static ResourceForAllTests resourceForAllTests;

  @BeforeAll
  static void setUpClass(){
    resourceForAllTests = new ResourceForAllTests("Before All Tests can begin");
  }

  @BeforeEach
  void setUp(){
    systemUnderTest = new SUT("Start of Individual Test Case");
  }

  @Test
//  @Disabled("This feature is under construction")
  void canReceiveRegularWorkTest() {
    boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();
    assertTrue(canReceiveRegularWork);
  }

  @Test
  @DisplayName("Workers Test")
//  @Disabled
  void additionalWorkTest(){
    boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();
    assertFalse(canReceiveAdditionalWork);
  }

//  @Test
//  void canReceiveAdditionalWorkTest() {
//
//  }

//  @Test
//  void itShouldClose() {
//
//  }

  @AfterEach
  void tearDown(){
    systemUnderTest.close();
  }


  @AfterAll
  static void tearDownClass(){
    resourceForAllTests.close();
  }
}