package cn.edu.hziee.service;

import cn.edu.hziee.mapper.ClassMapper;
import cn.edu.hziee.model.Class;
import cn.edu.hziee.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
@Service
@Transactional
public class ClassService {
    @Autowired

    private ClassMapper classMapper;


    public void addClass(Class cs){
        this.classMapper.insert(cs);
    }
    public void delete(int id){

        this.classMapper.delete(id);

    }

    public List<Class> findByClassName(String name){

        return this.classMapper.findByClassName(name);

    }
    public Class findByClassId(int id) {

        return this.classMapper.findByClassId(id);

    }
    public void update(Class cs){

        this.classMapper.update(cs);

    }

    //分页数据
    public Page<Class> findByClassPage(int currentPage, HashMap<String, Object> params) {

        HashMap<String, Object> classmap = new HashMap<String, Object>();

        Page<Class> classpage = new Page<Class>();

        //封装当前页数

        classpage.setCurrPage(currentPage);

        //每页显示的数据

        int pageSize = 4;//当前总共是9条，那么可以计算得到3页数据

        classpage.setPageSize(pageSize);

        //封装带条件查询的总记录数

        int totalCount = classMapper.selectClassCount(params);

        classpage.setTotalCount(totalCount);

        //封装总页数

        Integer totalcount = totalCount;

        //计算页数，如果整除，那么直接返回冒号左边的值，否则还需要加1

        Integer num = totalcount%pageSize==0? totalcount / pageSize: totalcount / pageSize+1;

        classpage.setTotalPage(num.intValue());//转换为整数

        classmap.put("start", (currentPage - 1) * pageSize);//起始的记录值

        classmap.put("size", classpage.getPageSize());//获取每个页面的pageSize

        classmap.put("class_name",params.get("class_name"));

        classmap.put("grade",params.get("grade"));

        classmap.put("frequency",params.get("frequency"));

        classmap.put("class_place",params.get("class_place"));

        classmap.put("class_size",params.get("class_size"));

        classmap.put("headmaster",params.get("headmaster"));

        //  map.put("查询条件参数",查询值)   如果后面要做带查询条件的分页，可以在这里添加查询参数，而查询条件参数可以在当前findByPage的方法里加一个参数

        List<Class> list = classMapper.findByClassPage(classmap);

        classpage.setList(list);

        return classpage;

    }
}
