package cn.edu.hziee.mapper;

import cn.edu.hziee.model.Doctor;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface DoctorMapper {
    public Doctor findDoctorById(int id);

    public  int insertDoctor(Doctor doctor);

    public Doctor findDoctorByIdName(String username);

    public List<Doctor> findByDoctorName(String doctor_name);

    public void updateUserBalanceByUid(Doctor doctor);

    public void insert(Doctor dt);

    public void delete(int id);

    public void update(Doctor dt);
    //分页

    //查询用户记录总数
    public int selectDoctorCount(HashMap<String, Object> map);

    //通过起始记录，和记录size放到一个hashMap再封装到List里

    public List<Doctor> findByDoctorPage(HashMap<String, Object> map);
}
