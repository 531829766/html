package cn.edu.hziee.controller;

import cn.edu.hziee.service.ClassService;
import cn.edu.hziee.util.Page;
import cn.edu.hziee.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
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

public class ClassController {


        @Autowired
        private ClassService classService;


        @RequestMapping("classlist")

        public String classtoList(Model model){

            List<Class> list = classService.findByClassName("李");

            System.out.println(list);

            model.addAttribute("classlist",list);//将数据库查询的数据传递到页面用JSTL、EL进行显示

            return "classlist";

        }


        @RequestMapping("classto_add")

        public String classtoAdd() {

            return "classadd";

        }
        @RequestMapping("classadd")

        public String classadd(Class cs) {

            classService.addClass(cs);

            return "redirect:classpage";

        }


        @RequestMapping("classdelete")

        public String classdelete(int[] ids) {

            if (ids != null) {//批量删除

                for (int id : ids) {

                    System.out.println("删除班级id==" + id);

                    classService.delete(id);

                }

            }

            return "redirect:classpage";

        }
        @RequestMapping("classdelete/{id}")
        public String classdelete(@PathVariable int id) {

            System.out.println("删除班级id==" + id);

            classService.delete(id);

            return "redirect:/classpage"; //这里的/page不要写成page，否则会出现路径错误

        }

        @RequestMapping(value = "classedit/{id}",method = RequestMethod.GET)
        public String classedit(@PathVariable int id, Model model) {

            Class cs = classService.findByClassId(id);//从数据库找到id对应的对象

            model.addAttribute("classdata",cs);//通过model传递到页面上去

            return "classedit";

        }

        @RequestMapping(value = "classedit",method = RequestMethod.POST)
        public String classedit(Class cs) {

            classService.update(cs);

            return "redirect:classpage";//重定向到分页数据显示

        }

        //分页查询
        @RequestMapping("classpage")
        public String classgetPage(@RequestParam(defaultValue = "1") int currentPage, Model model,
                              HttpServletRequest request, String class_name, String grade, String frequency, String class_place, String class_size, String headmaster) {

            HashMap<String, Object> classmap = new HashMap<String, Object>();

            classmap.put("class_name", class_name);

            classmap.put("grade", grade);

            classmap.put("frequency", frequency);

            classmap.put("class_place", class_place);

            classmap.put("class_size", class_size);

            classmap.put("headmaster", headmaster);

            Page<Class> classpage = classService.findByClassPage(currentPage, classmap);

            model.addAttribute("classpageData", classpage);//设置一个属性

            model.addAttribute("classparams", classmap);

            return "classpage";
        }
        }

