package cn.edu.hziee.controller;

import cn.edu.hziee.model.Doctor;
import cn.edu.hziee.service.DoctorService;
import cn.edu.hziee.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("doctorto_add")
    public String doctortoAdd() {
        return "doctoradd";
    }

    @RequestMapping("doctoradd")
    public String doctoradd(Doctor ct) {

        doctorService.addDoctor(ct);

        return "redirect:doctorpage";

    }


    @RequestMapping("doctordelete")

    public String doctordelete(int[] ids) {

        if (ids != null) {//批量删除

            for (int id : ids) {

                System.out.println("删除班级id==" + id);

                doctorService.delete(id);

            }

        }

        return "redirect:doctorpage";

    }

    @RequestMapping("doctordelete/{id}")
    public String doctordelete(@PathVariable int id) {

        System.out.println("删除班级id==" + id);

        doctorService.delete(id);

        return "redirect:/doctorpage"; //这里的/page不要写成page，否则会出现路径错误

    }

    @RequestMapping(value = "doctoredit/{id}",method = RequestMethod.GET)
    public String doctoredit(@PathVariable int id, Model model) {

        Doctor dt = doctorService.findByDoctorId(id);//从数据库找到id对应的对象

        model.addAttribute("doctordata",dt);//通过model传递到页面上去

        return "doctoredit";

    }

    @RequestMapping(value = "doctoredit",method = RequestMethod.POST)
    public String doctoredit(Doctor dt) {

        doctorService.update(dt);

        return "redirect:doctorpage";//重定向到分页数据显示

    }

    //分页查询
    @RequestMapping("doctorpage")
    public String doctorgetPage(@RequestParam(defaultValue = "1") int currentPage, Model model,
                                   HttpServletRequest request, String doctor_name, Integer doctor_phone,String doctor_specialty,
                                   Integer doctor_identity,String doctor_password) {

        HashMap<String, Object> doctormap = new HashMap<String, Object>();

        doctormap.put("doctor_name",doctor_name);

        doctormap.put("doctor_phone",doctor_phone);

        doctormap.put("doctor_specialty",doctor_specialty);

        doctormap.put("doctor_identity",doctor_identity);

        doctormap.put("doctor_password",doctor_password);

        Page<Doctor> doctorpage = doctorService.findByDoctorPage(currentPage, doctormap);

        System.out.println(doctorpage);
        model.addAttribute("doctorpageData", doctorpage);//设置一个属性

        model.addAttribute("doctorparams", doctormap);

        return "doctorpage";
    }
}
