package cn.edu.hziee.service;

import cn.edu.hziee.mapper.StudentMapper;
import cn.edu.hziee.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

@Transactional

public class StudentService {

    @Autowired

    private StudentMapper studentMapper;



    public void addStudent(Student student){

        this.studentMapper.insert(student);

    }



    public List<Student> findByName(String name){

        return this.studentMapper.findByName(name);

    }



}