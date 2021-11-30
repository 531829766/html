package cn.edu.hziee.dao;

import cn.edu.hziee.model.Student;

import java.util.List;

public interface StudentDao {
    public Student findById(int id);
    public List<Student> findByName(String name);
}
