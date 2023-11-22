package com.example.service;

import com.example.lfj.Student;
import com.example.lfj.teacher;

import java.util.List;

public interface lfjStudentservice {
    Student getStudentbyid(int id);


    public Integer UpdateStudent(Student student);

    public Integer deleteStudent(Integer id);

    public Integer insertStudent(Student student);

    public List<Student> getall();
    Student getcourseWithStudentById(int id);
    teacher getcourseWithTeacherById(int id);
}
