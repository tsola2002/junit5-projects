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
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.sameInstance;

import com.tsola2002.calculator.Calculator;
import org.junit.jupiter.api.Test;

public class HamcrestTest {

  @Test
  void stringMatchers(){
    // assertThat("Hello", is(anything()));
    // assertThat(13, describedAs("13 is not equal to 12", is(equalTo((12)))));
    assertThat("World", is(equalTo("World")));
  }

  @Test
  void logicalMatchers(){
    assertThat("myValue", allOf(startsWith("my"),containsString("Val")));
    assertThat("myValue", anyOf(startsWith("foo"),containsString("Val")));
    assertThat("World", is(not(equalTo("Word"))));
  }

  @Test
  void objectMatchers(){
    assertThat("World", is(equalTo("World")));
    assertThat("true", hasToString("true"));
    assertThat(new Calculator(), instanceOf(Calculator.class));
    assertThat("myValue", is(notNullValue()));
    //assertThat("myValue", is(nullValue()));

    Object myValue = new Object();
    Object nullValue = myValue;
    assertThat(myValue, sameInstance(nullValue));

  }






}
