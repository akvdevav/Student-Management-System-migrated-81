package com.himanshuanand.Dao;

import com.himanshuanand.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by himanshuanand on 5/7/17.
 */
@Repository
@Transactional
public class MongoStudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Student> getAllStudents() {
        String jpql = "SELECT s FROM Student s";
        List<Student> students = entityManager.createQuery(jpql, Student.class).getResultList();
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void removeStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void insertStudent(Student student) {
        entityManager.persist(student);
    }
}