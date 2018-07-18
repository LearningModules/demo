package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * Created by reji on 18/07/18.
 */
@RestController
public class StudentController {
    Logger logger = Logger.getLogger(StudentController.class.getName());
    @Autowired
    StudentRepository studentRepository;
    @PostMapping(path = "/student")
    ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        logger.info("Received new student addition request");
        return ResponseEntity.ok().body(studentRepository.save(student));
    }

    @GetMapping(path = "/student/{studentId}")
    ResponseEntity<Student> readStudent(@PathVariable("studentId") Long studentId)
    {
        logger.info("Get request for student : "+studentId);

        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent())
        {
            logger.info("Student found for studentId : "+studentId);
            logger.info("Returning : "+student.get());
            return ResponseEntity.ok().body(student.get());
        }
        else
        {
            logger.info("No student found for studentId : "+studentId);
            return ResponseEntity.notFound().build();
        }

    }
}