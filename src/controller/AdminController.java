package controller;

import model.Admin;
import service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AdminService;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @RequestMapping("user_login")
    public String Login2(Admin ad){
        String a_username = ad.getA_username();
        String a_password = ad.getA_password();
        Admin c =adminService.findAdminByIdName(a_username);
        System.out.println(c);
        if (ad == null){
            System.out.println("用户名或者密码错误");
        }else
        {
            if (a_username.equals(ad.getA_username()) && a_password.equals(ad.getA_password())){
                return "redirect:doctorpage";
            }else {
                return "success";
            }
        }
        return "redirect:page";
    }
        @RequestMapping("login2")
        public String ToLogin2(){
            return "login2";
        }


}
