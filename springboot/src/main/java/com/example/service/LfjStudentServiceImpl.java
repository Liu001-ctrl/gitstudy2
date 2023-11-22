package com.example.service;

import com.example.lfj.teacher;
import com.example.mapper.LfjStudentMapper;
import com.example.lfj.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LfjStudentServiceImpl implements lfjStudentservice {
    @Autowired
    private LfjStudentMapper studentMapper;

    @Override
    public Student getStudentbyid(int id) {
        System.out.println("查询"+id+"学生");
        Student student = studentMapper.getStudentbyid(id);
        return student;
    }

    @Override
    public Integer UpdateStudent(Student student) {
        System.out.println("updateStudent:"+student);
        studentMapper.UpdateStudent(student);
        return 1;
    }

    @Override
    public Integer deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);
        System.out.println("deleteStudent:"+id);
        return id;
    }

    @Override
    public Integer insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public List<Student> getall() {
        return studentMapper.getall();
    }
    @Override
    public Student getcourseWithStudentById(int id) {
        return studentMapper.getcourseWithStudentById(id);
    }
    @Override
    public teacher getcourseWithTeacherById(int id) {
        return studentMapper.getcourseWithTeacherById(id);
    }
}
