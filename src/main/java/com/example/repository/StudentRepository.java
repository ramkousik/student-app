package com.example.repository;

import com.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(student);
    }

    public Student findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<Student> criteriaQuery = session.getCriteriaBuilder().createQuery(Student.class);
        criteriaQuery.from(Student.class);
        return session.createQuery(criteriaQuery).getResultList();
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        session.delete(student);
    }
}

