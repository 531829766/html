package cn.edu.hziee.mapper;

import cn.edu.hziee.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface StudentMapper {
    public Student findById(int id);

    public List<Student> findByName(String name);

    public void insert(Student student);

    public void delete(int id);

    public void update(Student student);
    //分页

    //查询用户记录总数
    public int selectCount(HashMap<String, Object> map);

    //通过起始记录，和记录size放到一个hashMap再封装到List里

    public List<Student> findByPage(HashMap<String, Object> map);








}
