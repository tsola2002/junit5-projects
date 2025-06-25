package com.tsola2002.datjpa.service;

import com.tsola2002.datjpa.entity.Student;
import com.tsola2002.datjpa.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  // INJECTING STUDENT REPOSITORY USING FIELD INJECTION
  @Autowired
  private StudentRepository studentRepository;

  public List<Student> getAllStudents(){

    return studentRepository.findAll();
  }

  public Student addStudent(Student student){
    return studentRepository.save(student);
  }

  public Student updateStudent(Long id, Student studentDetails){
    return studentRepository.findById(id).map(student -> {
      student.setStudentName(studentDetails.getStudentName());
      student.setDateOfBirth(studentDetails.getDateOfBirth());
      student.setStudentAddress(studentDetails.getStudentAddress());
      return studentRepository.save(student);
    }).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
  }

  public void deleteStudent(Long id){
    studentRepository.deleteById(id);
  }



}
