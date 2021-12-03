package cn.edu.hziee.service;

import cn.edu.hziee.mapper.ExperienceMapper;
import cn.edu.hziee.model.Experience;
import cn.edu.hziee.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
@Service
@Transactional
public class ExperienceService {
    @Autowired

    private ExperienceMapper experienceMapper;


    public void addExperience(Experience ex){
        this.experienceMapper.insert(ex);
    }
    public void delete(int id){

        this.experienceMapper.delete(id);

    }

    public List<Experience> findByExperienceName(String name){

        return this.experienceMapper.findByExperienceName(name);

    }
    public Experience findByExperienceId(int id) {

        return this.experienceMapper.findByExperienceId(id);

    }
    public void update(Experience ex){

        this.experienceMapper.update(ex);

    }

    //分页数据
    public Page<Experience> findByExperiencePage(int currentPage, HashMap<String, Object> params) {

        HashMap<String, Object> experiencemap = new HashMap<String, Object>();

        Page<Experience> experiencepage = new Page<Experience>();

        //封装当前页数

        experiencepage.setCurrPage(currentPage);

        //每页显示的数据

        int pageSize = 4;//当前总共是9条，那么可以计算得到3页数据

        experiencepage.setPageSize(pageSize);

        //封装带条件查询的总记录数

        int totalCount = experienceMapper.selectExperienceCount(params);

        experiencepage.setTotalCount(totalCount);

        //封装总页数

        Integer totalcount = totalCount;

        //计算页数，如果整除，那么直接返回冒号左边的值，否则还需要加1

        Integer num = totalcount%pageSize==0? totalcount / pageSize: totalcount / pageSize+1;

        experiencepage.setTotalPage(num.intValue());//转换为整数

        experiencemap.put("start", (currentPage - 1) * pageSize);//起始的记录值

        experiencemap.put("size", experiencepage.getPageSize());//获取每个页面的pageSize

        experiencemap.put("class_name",params.get("class_name"));

        experiencemap.put("grade",params.get("grade"));

        experiencemap.put("frequency",params.get("frequency"));

        experiencemap.put("class_place",params.get("class_place"));

        experiencemap.put("class_size",params.get("class_size"));

        experiencemap.put("headmaster",params.get("headmaster"));

        //  map.put("查询条件参数",查询值)   如果后面要做带查询条件的分页，可以在这里添加查询参数，而查询条件参数可以在当前findByPage的方法里加一个参数

        List<Experience> list = experienceMapper.findByExperiencePage(experiencemap);

        experiencepage.setList(list);

        return experiencepage;

    }
}
