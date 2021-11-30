package cn.edu.hziee.service;

import cn.edu.hziee.mapper.StudentMapper;
import cn.edu.hziee.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public void addStudent(Student student){
        this.studentMapper.insert(student);
        int i = 1/0;//设置异常语句
    }
}
