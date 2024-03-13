package com.company.sprintSp1.database;

import com.company.sprintSp1.model.Student;
import lombok.Getter;

import java.util.ArrayList;

public class StudentDB {
    public static ArrayList<Student> studentArrayList = new ArrayList<>();
    public static ArrayList<Student> getAllStudent(){
        return studentArrayList;
    }

    public static void addStudent(Student student){
        studentArrayList.add(student);
    }

    public static Student getStudent(Long id){
        for (Student student: studentArrayList){
            if (student.getId()==id){
                return student;
            }
        }
        return null;
    }
}
