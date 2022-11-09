package com.company.controller;

import com.company.entity.*;
import com.company.service.inter.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller("/info")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    @ApiOperation("it shows all the informations about students")
    public ModelAndView getAllStudents(){
        ModelAndView mv = new ModelAndView("show-all-students");
        List<Students> list = studentService.getAllStudents();
        mv.addObject("students", list);
        return mv;
    }

    @GetMapping("/showSaveForm")
    @ApiOperation("It is used to redirect to the another view")
    public ModelAndView addNewStudent(){
        ModelAndView mv = new ModelAndView("add-new-student");
        Students student = new Students();
        mv.addObject("student", student);
        return mv;
    }

    @PostMapping("/addStudent")
    @ApiOperation("It is used to save a student")
    public String saveStudent(@ModelAttribute Students student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/showUpdateForm")
    @ApiOperation("It is used to redirect to the another view")
    public ModelAndView updateStudent(@RequestParam int id){
        ModelAndView mv = new ModelAndView("add-new-student");
        Students student = studentService.findStudentById(id);
        mv.addObject("student", student);
        return mv;
    }

    @GetMapping("/deleteStudent")
    @ApiOperation("it is used to delete a student")
    public String deleteStudent(@RequestParam int id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
