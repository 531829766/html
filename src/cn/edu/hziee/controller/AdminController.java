package cn.edu.hziee.controller;

import cn.edu.hziee.model.Admin;
import cn.edu.hziee.model.Consumer;
import cn.edu.hziee.service.AdminService;
import cn.edu.hziee.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @Autowired
    private ConsumerService consumerService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("user_login")
    public String Login2(Admin ad){
        String a_username = ad.getA_username();
        String a_password = ad.getA_password();
        ad = adminService.findAdminByIdName(a_username);
        System.out.println(ad);
        if (ad == null){
            System.out.println("用户名或者密码错误");
        }else
        {
            if (a_username.equals(ad.getA_username()) && a_password.equals(ad.getA_password())){
                return "doctorpage";
            }else {
                return "success";
            }
        }
        return "login2";
    }
        @RequestMapping("login2")
        public String ToLogin2(){
            return "login2";
        }


}
