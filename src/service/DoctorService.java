package service;


import mapper.DoctorMapper;
import model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.Page;

import java.util.HashMap;
import java.util.List;


@Service
@Transactional
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    public int register(Doctor doctor){
        return this.doctorMapper.insertDoctor(doctor);
    }

    public Doctor findDoctorById(int id){
        return this.doctorMapper.findDoctorById(id);
    }

    public Doctor findDoctorByIdName(String username){return this.doctorMapper.findDoctorByIdName(username);}

    public void updateUserBalanceByUid(Doctor doctor){this.doctorMapper.updateUserBalanceByUid(doctor);}

    public void addDoctor(Doctor dt){
        this.doctorMapper.insert(dt);
    }

    public void delete(int id){

        this.doctorMapper.delete(id);

    }

    public List<Doctor> findByDoctorName(String name){

        return this.doctorMapper.findByDoctorName(name);

    }

    public Doctor findByDoctorId(int id) {
        return this.doctorMapper.findDoctorById(id);
    }

    public void update(Doctor ct){

        this.doctorMapper.update(ct);

    }


    //分页数据
    public Page<Doctor> findByDoctorPage(int currentPage, HashMap<String, Object> params) {

        HashMap<String, Object> doctormap = new HashMap<String, Object>();

        Page<Doctor> doctorpage = new Page<Doctor>();

        //封装当前页数

        doctorpage.setCurrPage(currentPage);

        //每页显示的数据

        int pageSize = 4;//当前总共是9条，那么可以计算得到3页数据

        doctorpage.setPageSize(pageSize);

        //封装带条件查询的总记录数

        int totalCount = doctorMapper.selectDoctorCount(params);

        doctorpage.setTotalCount(totalCount);

        //封装总页数

        Integer totalcount = totalCount;

        //计算页数，如果整除，那么直接返回冒号左边的值，否则还需要加1

        Integer num = totalcount%pageSize==0? totalcount / pageSize: totalcount / pageSize+1;

        doctorpage.setTotalPage(num.intValue());//转换为整数

        doctormap.put("start", (currentPage - 1) * pageSize);//起始的记录值

        doctormap.put("size", doctorpage.getPageSize());//获取每个页面的pageSize

        doctormap.put("doctor_name",params.get("doctor_name"));

        doctormap.put("doctor_phone",params.get("doctor_phone"));

        doctormap.put("doctor_identity",params.get("doctor_identity"));

        doctormap.put("doctor_specialty",params.get("doctor_specialty"));

        doctormap.put("doctor_password",params.get("doctor_password"));

        //  map.put("查询条件参数",查询值)   如果后面要做带查询条件的分页，可以在这里添加查询参数，而查询条件参数可以在当前findByPage的方法里加一个参数

        List<Doctor> list = doctorMapper.findByDoctorPage(doctormap);

        doctorpage.setList(list);

        return doctorpage;

    }
}
