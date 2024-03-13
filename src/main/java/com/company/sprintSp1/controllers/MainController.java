package com.company.sprintSp1.controllers;

import com.company.sprintSp1.database.StudentDB;
import com.company.sprintSp1.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {
    private int ids = 0;
    @GetMapping(value = "/")
    public String indexPage(Model model){
        ArrayList<Student> students = StudentDB.getAllStudent();
        model.addAttribute("students", students);
        return "index";
    }
    @GetMapping(value = "/add")
    public String addPage(Model model){
        return "add";
    }
    @PostMapping(value = "/addUser")
    public String addUser(@RequestParam(name = "name") String userName,
                          @RequestParam(name = "surname") String userSurname,
                          @RequestParam(name = "exam") int exam){
        Student student = new Student();
        ids++;
        student.setId((long) ids);
        student.setName(userName);
        student.setSurname(userSurname);
        student.setExam(exam);
        if (exam >= 90){
            student.setMark("A");
        } else if (exam < 90 && exam >= 75) {
            student.setMark("B");
        } else if (exam < 75 && exam >= 60) {
            student.setMark("C");
        } else if (exam < 60 && exam >= 50) {
            student.setMark("D");
        } else if (exam < 50) {
            student.setMark("F");
        }
        StudentDB.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(name = "id") Long id,
                          Model model){
        Student student = StudentDB.getStudent(id);
        model.addAttribute("student", student);
        return "details";
    }
}
