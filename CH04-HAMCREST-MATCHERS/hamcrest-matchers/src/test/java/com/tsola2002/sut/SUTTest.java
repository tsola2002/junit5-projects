package com.tsola2002.sut;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
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
  @DisplayName("Regular Workers Test")
  @Disabled("This feature is under construction")
  void canReceiveRegularWorkTest() {

    boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();
    assertTrue(canReceiveRegularWork);
  }

  @Test
  @DisplayName("Additional Workers Test")
//  @Disabled
  void additionalWorkTest(){
    boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();
    assertFalse(canReceiveAdditionalWork);
  }


  @Test
  @DisplayName("A job is executed within a timeout")
  void testTimeout() throws InterruptedException {
    systemUnderTest.addJob(new Job("Job 1"));
    assertTimeout(ofMillis(500), () ->
        systemUnderTest.run());
  }



  @AfterEach
  void tearDown(){
    systemUnderTest.close();
  }


  @AfterAll
  static void tearDownClass(){
    resourceForAllTests.close();
  }
}