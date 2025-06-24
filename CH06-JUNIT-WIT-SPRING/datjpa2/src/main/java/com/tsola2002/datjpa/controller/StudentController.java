package com.tsola2002.datjpa.controller;

import com.tsola2002.datjpa.entity.Student;
import com.tsola2002.datjpa.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping
  //@CrossOrigin(origins="http://localhost:5173/")
  public List<Student> getAllStudents(){

    return studentService.getAllStudents();
  }

  @PostMapping
  //@CrossOrigin(origins="http://localhost:5173/")
  public Student addStudent(@RequestBody Student student){
    return studentService.addStudent(student);
  }

  @PutMapping("/{id}")
  //@CrossOrigin(origins="http://localhost:5173/")
  public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails){
    return studentService.updateStudent(id, studentDetails);
  }

  @DeleteMapping("/{id}")
  //@CrossOrigin(origins="http://localhost:5173/")
  public void deleteStudent(@PathVariable Long id){
    studentService.deleteStudent(id);
  }

}
