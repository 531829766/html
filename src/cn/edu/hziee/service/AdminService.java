package cn.edu.hziee.service;

import cn.edu.hziee.mapper.AdminMapper;
import cn.edu.hziee.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public int register(Admin admin){
        return this.adminMapper.insertAdmin(admin);
    }

    public Admin findAdminById(int a_id){
        return this.adminMapper.findAdminById(a_id);
    }


    public Admin findAdminByIdName(String a_username){
        System.out.println("ad"+a_username);
        return this.adminMapper.findAdminByIdName(a_username);
    }

    public void updateUserBalanceByUid(Admin admin){this.adminMapper.updateUserBalanceByUid(admin);}

}
