package cn.edu.hziee.controller;

import cn.edu.hziee.model.Admin;
import cn.edu.hziee.model.Consumer;
import cn.edu.hziee.service.AdminService;
import cn.edu.hziee.service.ConsumerService;
import cn.edu.hziee.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("login")
    public String Login(Consumer c1){
        String username = c1.getUsername();
        String password = c1.getPassword();
        c1=consumerService.findConsumerByIdName(username);
        if (c1 == null){
            return "login";
        }else
        {
            if (username.equals(c1.getUsername()) && password.equals(c1.getPassword())){
                return "doctorpage";
            }else {
                return "success";
            }
        }
    }

    @RequestMapping("to_shopping")
    public String toShopping(){
        return "shopping";
    }
    @RequestMapping("check_notice")
    public String toShopping_notice(){
        return "notice";
    }
    @RequestMapping("shop_notice")
    public String to_shop_notice(){
        return "shop_notice";
    }
    @RequestMapping("personal")
    public String topersonal(){
        return "personal";
    }

 @RequestMapping("consumerto_add")
 public String consumertoAdd() {
    return "consumeradd";
}

    @RequestMapping("consumeradd")
    public String consumeradd(Consumer ct) {

        consumerService.addConsumer(ct);

        return "redirect:consumerpage";

    }


    @RequestMapping("consumerdelete")

    public String consumerdelete(int[] ids) {

        if (ids != null) {//批量删除

            for (int id : ids) {

                System.out.println("删除班级id==" + id);

                consumerService.delete(id);

            }

        }

        return "redirect:consumerpage";

    }

    @RequestMapping("consumerdelete/{id}")
    public String consumerdelete(@PathVariable int id) {

        System.out.println("删除班级id==" + id);

        consumerService.delete(id);

        return "redirect:/consumerpage"; //这里的/page不要写成page，否则会出现路径错误

    }

    @RequestMapping(value = "consumeredit/{id}",method = RequestMethod.GET)
    public String consumeredit(@PathVariable int id, Model model) {

        Consumer ct = consumerService.findByConsumerId(id);//从数据库找到id对应的对象

        model.addAttribute("consumerdata",ct);//通过model传递到页面上去

        return "consumeredit";

    }

    @RequestMapping(value = "consumeredit",method = RequestMethod.POST)
    public String consumeredit(Consumer ct) {

        consumerService.update(ct);

        return "redirect:consumerpage";//重定向到分页数据显示

    }

    //分页查询
    @RequestMapping("consumerpage")
    public String commoditygetPage(@RequestParam(defaultValue = "1") int currentPage, Model model,
                                   HttpServletRequest request, String username, Integer balance) {

        HashMap<String, Object> consumermap = new HashMap<String, Object>();

        consumermap.put("username", username);

        consumermap.put("balance", balance);

        Page<Consumer> consumerpage = consumerService.findByConsumerPage(currentPage, consumermap);

        model.addAttribute("consumerpageData", consumerpage);//设置一个属性

        model.addAttribute("consumerparams", consumermap);

        return "consumerpage";
    }
}

