package cn.edu.hziee.mapper;

import cn.edu.hziee.model.Experience;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface ExperienceMapper {
    public Experience findByExperienceId(int id);

    public List<Experience> findByExperienceName(String name);

    public void insert(Experience Ex);

    public void delete(int id);

    public void update(Experience Ex);
    //分页

    //查询用户记录总数
    public int selectExperienceCount(HashMap<String, Object> map);

    //通过起始记录，和记录size放到一个hashMap再封装到List里

    public List<Experience> findByExperiencePage(HashMap<String, Object> map);

}
