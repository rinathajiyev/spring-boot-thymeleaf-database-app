package com.company.service;

import com.company.dao.*;
import com.company.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Students saveStudent(Students student) {
       return studentRepository.save(student);
    }

    @Override
    public Students updateStudent(int id, Students student) {
        Students s = studentRepository.findById(id).get();
        s.setName(student.getName());
        s.setSurname(student.getSurname());
        s.setAge(student.getAge());
        s.setEmail(student.getEmail());
        s.setPassword(student.getPassword());
        s.setPhone(student.getPhone());
        s.setBirthdate(student.getBirthdate());

        return studentRepository.save(s);
    }

    @Override
    public Students findStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
