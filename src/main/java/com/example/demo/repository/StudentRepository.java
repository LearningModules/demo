package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
/**
 * Created by reji on 18/07/18.
 */
@Component
public interface StudentRepository extends CrudRepository<Student, Long> {

}
