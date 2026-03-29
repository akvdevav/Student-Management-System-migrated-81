package com.himanshuanand.Dao;

import com.himanshuanand.Entity.Student;
import com.himanshuanand.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by himanshuanand on 5/4/17.
 */
@Repository
@Qualifier("StudentDaoImpl")
@Transactional
public class StudentDaoImpl implements StudentDao {

    private final StudentRepository studentRepository;

    public StudentDaoImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

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