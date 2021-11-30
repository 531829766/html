package cn.edu.hziee.mapper;

import cn.edu.hziee.model.Student;

import java.util.List;

public interface StudentMapper {
    public Student findById(int id);

    public List<Student> findByName(String name);

    public void insert(Student student);
}
