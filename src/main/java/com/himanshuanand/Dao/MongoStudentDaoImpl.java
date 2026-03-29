package com.himanshuanand.Dao;

import com.himanshuanand.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by himanshuanand on 5/7/17.
 */
@Repository
@Qualifier("jpaData")
public class MongoStudentDaoImpl implements StudentDao {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void removeStudentById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void insertStudent(Student student) {
        studentRepository.save(student);
    }
}