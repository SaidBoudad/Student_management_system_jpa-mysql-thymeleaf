package com.saidboudad.demo;

import com.saidboudad.demo.entity.Student;
import com.saidboudad.demo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    //JUnit test for saveStudent
    @Test
    @Order(1)
    @Rollback
    public void saveStudentTest(){
        Student student = Student.builder()
                .firstName("saido")
                .lastName("boudad")
                .phoneNumber("00212633736058")
                .build();
        studentRepository.save(student);
        log.info("this is the Id for the new student,{}",student.getId());
        assertNotNull(student.getId());
    }
    @Test
    @Order(2)
    @Rollback
    public void getStudentByIdTest(){
        Student student = studentRepository.findById(2L).get();
        Assertions.assertThat(student.getId()).isEqualTo(2L);
    }
    @Test
    @Order(3)
    @Rollback
    public void getAllStudentsTest(){
        List<Student> students = studentRepository.findAll();
        Assertions.assertThat(students.size()).isGreaterThan(0);
    }
    @Test
    @Order(4)
    @Rollback
    public void updateStudentTest(){
        Student student = studentRepository.findById(2L).get();
        student.setFirstName("saidup");
        Student studentUpdated = studentRepository.save(student);
        Assertions.assertThat(studentUpdated.getFirstName()).isEqualTo("saidup");

    }
   @Test
   @Order(5)
   @Rollback
   public void deleteStudentTest(){
       Student student = studentRepository.findById(23L).get();
       studentRepository.delete(student);
       Optional<Student> deletedStudent = studentRepository.findById(23L);

       org.junit.jupiter.api.Assertions.assertFalse(deletedStudent.isPresent());
   }


}
