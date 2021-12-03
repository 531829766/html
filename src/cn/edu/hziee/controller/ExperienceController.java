package cn.edu.hziee.controller;

import cn.edu.hziee.mapper.ExperienceMapper;
import cn.edu.hziee.model.Experience;
import cn.edu.hziee.service.ExperienceService;
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
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;


    @RequestMapping("Experiencelist")

    public String ExperiencetoList(Model model){

       // List<Experience> list = ExperienceService.findByExperienceName("李");

        //System.out.println(list);

        //model.addAttribute("experiencelist",list);//将数据库查询的数据传递到页面用JSTL、EL进行显示

        return "experiencelist";

    }


    @RequestMapping("experienceto_add")

    public String experiencetoAdd() {

        return "experienceadd";

    }
    @RequestMapping("experienceadd")

    public String experienceadd(Experience cs) {

        experienceService.addExperience(cs);

        return "redirect:experiencepage";

    }


    @RequestMapping("experiencedelete")

    public String classdelete(int[] ids) {

        if (ids != null) {//批量删除

            for (int id : ids) {

                System.out.println("删除班级id==" + id);

                experienceService.delete(id);

            }

        }

        return "redirect:experiencepage";

    }
    @RequestMapping("experiencedelete/{id}")
    public String experiencedelete(@PathVariable int id) {

        System.out.println("删除班级id==" + id);

        experienceService.delete(id);

        return "redirect:/classpage"; //这里的/page不要写成page，否则会出现路径错误

    }

    @RequestMapping(value = "experienceedit/{id}",method = RequestMethod.GET)
    public String classedit(@PathVariable int id, Model model) {

        //Experience cs = experienceService.findByexperienceId(id);//从数据库找到id对应的对象

       // model.addAttribute("classdata",cs);//通过model传递到页面上去

        return "experienceedit";

    }
    @RequestMapping(value = "experienceedit",method = RequestMethod.POST)
    public String classedit(Class cs) {

        //experienceService.update(cs);

        return "redirect:experiencepage";//重定向到分页数据显示

    }

    //分页查询
    @RequestMapping("experiencepage")
    public String experiencegetPage(@RequestParam(defaultValue = "1") int currentPage, Model model,
                               HttpServletRequest request, String class_name, String grade, String frequency, String class_place, String class_size, String headmaster) {

        HashMap<String, Object> experiencemap = new HashMap<String, Object>();

        experiencemap.put("class_name", class_name);

        experiencemap.put("grade", grade);

        experiencemap.put("frequency", frequency);

        experiencemap.put("class_place", class_place);

        experiencemap.put("class_size", class_size);

        experiencemap.put("headmaster", headmaster);

        //Page<Experience> experiencepage = experienceService.findByexperiencePage(currentPage, experiencemap);

        //model.addAttribute("experiencepageData", experiencepage);//设置一个属性

        model.addAttribute("experienceparams", experiencemap);

        return "experiencepage";
    }

}
