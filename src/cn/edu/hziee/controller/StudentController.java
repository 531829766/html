package cn.edu.hziee.controller;

import cn.edu.hziee.model.Student;
import cn.edu.hziee.service.StudentService;
import cn.edu.hziee.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;


@Controller

public class StudentController {

    @Autowired

    private StudentService studentService;



    @RequestMapping("list")
    public String toList(Model model){

        List<Student> list = studentService.findByName("");

        System.out.println(list);

        model.addAttribute("list",list);//将数据库查询的数据传递到页面用JSTL、EL进行显示

        return "list";


    }


    @RequestMapping("to_add")
    public String toAdd() {

        return "add";

    }

    @RequestMapping("add")
    public String add(Student student) {

        studentService.addStudent(student);

        return "redirect:page";

    }


    @RequestMapping("delete")
    public String delete(int[] ids) {

        if (ids != null) {//批量删除

            for (int id : ids) {

                System.out.println("删除学生id==" + id);

                studentService.delete(id);

            }

        }

        return "redirect:page";

    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable int id) {

        System.out.println("删除学生id==" + id);

        studentService.delete(id);

        return "redirect:/page"; //这里的/page不要写成page，否则会出现路径错误

    }

    @RequestMapping(value = "edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable int id,Model model) {

        Student student = studentService.findById(id);//从数据库找到id对应的对象

        model.addAttribute("data",student);//通过model传递到页面上去

        return "edit";

    }

    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public String edit(Student student) {

        studentService.update(student);

        return "redirect:page";//重定向到分页数据显示

    }

    //分页查询
    @RequestMapping("page")
    public String getPage(
            @RequestParam(defaultValue = "1")
                    int currentPage, Model model,
                          HttpServletRequest request,String code,String username,Integer age,String gender)
    {

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("code",code);

        map.put("username",username);

        map.put("age",age);

        map.put("gender",gender);

        Page<Student> page = studentService.findByPage(currentPage,map);

        model.addAttribute("pageData", page);//设置一个属性

        model.addAttribute("params",map);

        return "page";

    }
}



