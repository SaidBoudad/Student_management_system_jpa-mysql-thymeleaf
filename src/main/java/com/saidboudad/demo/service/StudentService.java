package com.saidboudad.demo.service;

import com.saidboudad.demo.entity.Student;

import java.util.List;


public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    Student updateStudent(Student student);
    void deleteStudent(Long id);

}
