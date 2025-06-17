package com.tsola2002.hamcrest;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.describedAs;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.array;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.sameInstance;


import com.tsola2002.calculator.Calculator;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HamcrestTest {

  @Test
  @DisplayName("Core Matchers")
  void stringMatchers(){
    assertThat("Hello", is(anything()));
    assertThat(12, describedAs("13 is not equal to 12", is(equalTo((12)))));
    assertThat("World", is(equalTo("World")));
  }

  @Test
  @DisplayName("Logical Matchers")
  void logicalMatchers(){
     assertThat("myValue", allOf(startsWith("my"),containsString("Val")));
     assertThat("myValue", anyOf(startsWith("foo"),containsString("Val")));
     assertThat("World", is(not(equalTo("Word"))));
  }

  @Test
  @DisplayName("Object Matchers")
  void objectMatchers(){
    assertThat("World", is(equalTo("World")));
    assertThat("true", hasToString("true"));
    assertThat(new Calculator(), instanceOf(Calculator.class));
    assertThat("myValue", is(notNullValue()));
    assertThat(null, is(nullValue()));

    Object myValue = new Object();
    Object nullValue = myValue;
    assertThat(myValue, sameInstance(nullValue));
  }

  @Test
  @DisplayName("Text Matchers")
  void textMatchers(){
    assertThat("true", equalToIgnoringCase("TRUE"));
    assertThat(" true ", equalToIgnoringWhiteSpace("true"));
    assertThat("myValue", containsString("Val"));
    assertThat("myValue", endsWith("Value"));
    assertThat("myValue", startsWith("my"));
  }

  @Test
  @DisplayName("Collection Matchers")
  void collectionMatchers(){
    assertThat(new Integer[]{10,20,30}, is(
        array(equalTo(10), equalTo(20), equalTo(30)))
    );
    assertThat(Arrays.asList("month", "day"), hasItem("month"));
    assertThat(new String[]{"month", "day"}, hasItemInArray("month"));
  }

  @Test
  @DisplayName("Number Matchers")
  void numberMatchers(){
    assertThat(2.06, is(closeTo(2.0, 0.07)));
    assertThat(4, greaterThan(3));
    assertThat(3, greaterThanOrEqualTo(3));
    assertThat(3, lessThan(4));
    assertThat(3, lessThanOrEqualTo(4));
  }










}
