package com.tsola2002.sut;

import java.util.Objects;

public class Job {

  // property for name
  private String name;

  // constructor
  public Job(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Job job = (Job) o;
    return Objects.equals(name, job.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "Job{" +
        "name='" + name + '\'' +
        '}';
  }
}
