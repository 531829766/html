package cn.edu.hziee.mapper;

import cn.edu.hziee.model.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface AdminMapper {

    public Admin findAdminById(int id);
    public  int insertAdmin(Admin admin);
    public Admin findAdminByIdName(String a_username);
    public void updateUserBalanceByUid(Admin admin);


}
