package com.tsola2002.sut;

public class ResourceForAllTests {

  private String resourceName;

  public ResourceForAllTests(String resourceName) {
    this.resourceName = resourceName;
    System.out.println(resourceName + " from class " + getClass().getSimpleName() +
        " is initializing from Resource class.");
  }

  public void close() {
    System.out.println("After All Tests are done" + resourceName + " from class "
        + getClass().getSimpleName() + " is closing.");
  }

}
