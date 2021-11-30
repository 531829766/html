package cn.edu.hziee.dao;

import cn.edu.hziee.model.Student;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class StudentDaoImpl  extends SqlSessionDaoSupport implements StudentDao{
    @Override
    public Student findById(int id) {
        return this.getSqlSession().selectOne("cn.edu.hziee.mapper.StudentMapper.findById",id);
    }

    @Override
    public List<Student> findByName(String name) {
        return this.getSqlSession().selectList("cn.edu.hziee.mapper.StudentMapper.findByName",name);

    }
}
