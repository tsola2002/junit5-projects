package com.tsola2002.sut;

public class SUT {

  private String systemName;

  // constructor
  public SUT(String systemName) {
    this.systemName = systemName;
    System.out.println(systemName + " from class " + getClass().getSimpleName() + " is initializing.");
  }

  public boolean canReceiveRegularWork() {
    System.out.println(systemName + " from class " + getClass().getSimpleName() + " can receive regular work.");
    return true;
  }

  public boolean canReceiveAdditionalWork() {
    System.out.println(systemName + " from class " + getClass().getSimpleName() + " cannot receive additional work.");
    return false;
  }

  public void close() {
    System.out.println(systemName + " from class " + getClass().getSimpleName() + " is closing.");
  }


}
