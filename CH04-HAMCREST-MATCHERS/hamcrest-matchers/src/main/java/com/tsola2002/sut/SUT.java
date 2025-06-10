package com.tsola2002.sut;

import java.util.ArrayList;
import java.util.List;

public class SUT {
  private String systemName;
  private List<Job> jobs = new ArrayList<>();
  private Job currentJob;

  // constructor
  public SUT(String systemName) {
    this.systemName = systemName;
    System.out.println(systemName + " from class " + getClass().getSimpleName() +
        " is initializing.");
  }
  public boolean canReceiveRegularWork() {
    System.out.println(systemName + " from class " + getClass().getSimpleName() +
        " can receive regular work.");
    return true;
  }
  public boolean canReceiveAdditionalWork() {
    System.out.println(systemName + " from class " + getClass().getSimpleName() +
        " can receive additional work.");
    return false;
  }

  public void addJob(Job job) {
    jobs.add(job);
  }

  public void run() {
    if (jobs.size() > 0) {
      currentJob = jobs.remove(0);
      System.out.println("Running job: " + currentJob);
      return;
    }
    throw new NoJobException("No jobs on the execution list!");
  }

  public void close() {
    System.out.println(systemName + " from class " + getClass().getSimpleName() +
        " is closing.");
  }


}
