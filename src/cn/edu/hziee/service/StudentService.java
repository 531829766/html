package cn.edu.hziee.service;

import cn.edu.hziee.mapper.StudentMapper;
import cn.edu.hziee.model.Student;
import cn.edu.hziee.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service

@Transactional

public class StudentService {

    @Autowired

    private StudentMapper studentMapper;

    public void addStudent(Student student){

        this.studentMapper.insert(student);

    }

    public void delete(int id){

        this.studentMapper.delete(id);

    }

    public List<Student> findByName(String name){

        return this.studentMapper.findByName(name);

    }
    public Student findById(int id) {

        return this.studentMapper.findById(id);

    }
    public void update(Student student){

        this.studentMapper.update(student);

    }

//分页数据
public Page<Student> findByPage(int currentPage,HashMap<String, Object> params) {

    HashMap<String, Object> map = new HashMap<String, Object>();

    Page<Student> page = new Page<Student>();

    //封装当前页数

    page.setCurrPage(currentPage);

    //每页显示的数据

    int pageSize = 4;//当前总共是9条，那么可以计算得到3页数据

    page.setPageSize(pageSize);

    //封装带条件查询的总记录数

    int totalCount = studentMapper.selectCount(params);

    page.setTotalCount(totalCount);

    //封装总页数

    Integer totalcount = totalCount;

    //计算页数，如果整除，那么直接返回冒号左边的值，否则还需要加1

    Integer num = totalcount%pageSize==0? totalcount / pageSize: totalcount / pageSize+1;

    page.setTotalPage(num.intValue());//转换为整数

    map.put("start", (currentPage - 1) * pageSize);//起始的记录值

    map.put("size", page.getPageSize());//获取每个页面的pageSize

    map.put("code",params.get("code"));

    map.put("username",params.get("username"));

    map.put("age",params.get("age"));

    map.put("nation",params.get("nation"));

    map.put("birthday",params.get("birthday"));

    map.put("native_place",params.get("native_place"));

    map.put("enter_time",params.get("enter_time"));

    map.put("department",params.get("department"));

    map.put("post",params.get("post"));



    //  map.put("查询条件参数",查询值)   如果后面要做带查询条件的分页，可以在这里添加查询参数，而查询条件参数可以在当前findByPage的方法里加一个参数

    List<Student> list = studentMapper.findByPage(map);

    page.setList(list);

    return page;

}
}
