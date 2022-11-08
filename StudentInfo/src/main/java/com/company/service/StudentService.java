package com.company.service;

import com.company.entity.*;

import java.util.*;

public interface StudentService {

    List<Students> getAllStudents();

    Students saveStudent(Students student);

    Students updateStudent(int id, Students student);

    Students findStudentById(int id);

    void deleteStudent(int id);
}
