package com.example.controller;
import com.example.lfj.Student;
import com.example.lfj.teacher;
import com.example.service.lfjStudentservice;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class Lfjcontroller {
    @Autowired
    private lfjStudentservice StudentService;
    @GetMapping("/getStudent/{id}")//设置查询方式
    // http://localhost:8082/api/getStudent/1
    public Student getStudentbyid(@PathVariable("id") Integer id)//通过@PathVariable获取id的路径
    {
        Student student=StudentService.getStudentbyid(id);
        return student;
    }
    @PutMapping ("/updatestudent/{id}")
    public Integer UpdateStudent(@RequestBody Student student)
    {
        Integer student1=StudentService.UpdateStudent(student);
        return student1;
    }

    @DeleteMapping("/delstudent/{id}")
    public  Integer deleteStudent(@PathVariable("id") int id)
    {
        Integer student2=StudentService.deleteStudent(id);
        return student2;
    }

    @GetMapping("/queryall")
    public List<Student> getall(){
        return StudentService.getall();
    }




    @PostMapping("/inserStudent")
    public Integer insertUser(@RequestBody Student student){
        return  StudentService.insertStudent(student);
    }
    @GetMapping("/getcourseWithStudentById/{id}")//设置查询方式
    // http://localhost:8082/api/getStudent/1
    public Student getcourseWithStudentById(@PathVariable("id") Integer id)//通过@PathVariable获取id的路径
    {
        Student student=StudentService.getcourseWithStudentById(id);
        return student;
    }
    @GetMapping("/getcourseWithTeacherById/{id}")//设置查询方式
    // http://localhost:8082/api/getStudent/1
    public teacher getcourseWithTeacherById(@PathVariable("id") Integer id)//通过@PathVariable获取id的路径
    {
        teacher course=StudentService.getcourseWithTeacherById(id);
        return course;
    }
}



