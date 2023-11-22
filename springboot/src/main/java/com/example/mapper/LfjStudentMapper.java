package com.example.mapper;

import com.example.lfj.Student;
import com.example.lfj.teacher;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LfjStudentMapper {

    Student getStudentbyid(int id);


    public Integer UpdateStudent(Student student);

    public Integer deleteStudent(Integer id);

    public Integer insertStudent(Student student);


    public List<Student> getall();

    Student getcourseWithStudentById(int id);
    teacher getcourseWithTeacherById(int id);

    List<Student> getAll();
}
