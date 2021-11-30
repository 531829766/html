package cn.edu.hziee.controller;

import cn.edu.hziee.model.Student;
import cn.edu.hziee.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


    @Controller

    public class StudentController {

        @Autowired

        private StudentService studentService;



        @RequestMapping("list")

        public String toList(Model model){

            List<Student> list = studentService.findByName("李");

            System.out.println(list);

            model.addAttribute("list",list);//将数据库查询的数据传递到页面用JSTL、EL进行显示

            return "list";

        }



        @RequestMapping("delete")

        public String delete(int[] ids){

            if (ids != null) {

                for (int id : ids) {

                    System.out.println("删除学生id=="+id);

                }

            }

            return "success";

        }

    }



