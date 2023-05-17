package com.saidboudad.demo.repository;

import com.saidboudad.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByFirstName(String firstName);
}
