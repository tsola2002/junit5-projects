package com.tsola2002.datjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="TBL_STUDENT")
public class Student {

  @Id
  @Column(name="COL_STUDENT_ID")
  private Long studentId;

  @Column(name="COL_STUDENT_NAME", nullable = false, length = 1000)
  private String studentName;

  @Column(name="COL_DATE_OF_BIRTH", nullable = false)
  private LocalDate dateOfBirth;

  @Column(name="COL_STUDENT_ADDRESS", nullable = false)
  private String studentAddress;

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getStudentAddress() {
    return studentAddress;
  }

  public void setStudentAddress(String studentAddress) {
    this.studentAddress = studentAddress;
  }
}
