package cn.edu.hziee.mapper;

import cn.edu.hziee.model.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ClassMapper {
    public Class findByClassId(int id);

    public List<Class> findByClassName(String name);

    public void insert(Class cs);

    public void delete(int id);

    public void update(Class cs);
    //分页

    //查询用户记录总数
    public int selectClassCount(HashMap<String, Object> map);

    //通过起始记录，和记录size放到一个hashMap再封装到List里

    public List<Class> findByClassPage(HashMap<String, Object> map);



}
