package cn.edu.hziee.controller;

import cn.edu.hziee.model.Notice;
import cn.edu.hziee.service.NoticeService;
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
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping("noticelist")
    public String noticetoList(Model model){
        List<Notice> list = noticeService.findByNoticeName("李");
        System.out.println(list);
        model.addAttribute("noticelist",list);//将数据库查询的数据传递到页面用JSTL、EL进行显示
        return "noticelist";
    }

    @RequestMapping("noticeto_add")
    public String commoditytoAdd() {
        return "noticeadd";
    }

    @RequestMapping("noticeadd")
    public String noticeadd(Notice ct) {

        noticeService.addNotice(ct);

        return "redirect:noticepage";

    }


    @RequestMapping("noticeydelete")

    public String noticedelete(int[] ids) {

        if (ids != null) {//批量删除

            for (int id : ids) {

                System.out.println("删除班级id==" + id);

                noticeService.delete(id);

            }

        }

        return "redirect:noticepage";

    }

    @RequestMapping("noticedelete/{id}")
    public String noticedelete(@PathVariable int id) {

        System.out.println("删除班级id==" + id);

        noticeService.delete(id);

        return "redirect:/noticepage"; //这里的/page不要写成page，否则会出现路径错误

    }

    @RequestMapping(value = "noticeedit/{id}",method = RequestMethod.GET)
    public String noticeedit(@PathVariable int id, Model model) {

        Notice nt = noticeService.findByNoticeId(id);//从数据库找到id对应的对象

        model.addAttribute("noticedata",nt);//通过model传递到页面上去

        return "noticeedit";

    }

    @RequestMapping(value = "noticeedit",method = RequestMethod.POST)
    public String noticeedit(Notice ct) {

        noticeService.update(ct);

        return "redirect:noticepage";//重定向到分页数据显示

    }

    //分页查询
    @RequestMapping("noticepage")
    public String noticegetPage(@RequestParam(defaultValue = "1") int currentPage, Model model,
                                   HttpServletRequest request, String title, String content) {

        HashMap<String, Object> noticemap = new HashMap<String, Object>();

        noticemap.put("title", title);

        noticemap.put("content", content);

        Page<Notice> noticepage = noticeService.findByNoticePage(currentPage, noticemap);

        model.addAttribute("noticepageData", noticepage);//设置一个属性

        model.addAttribute("noticeparams", noticemap);

        return "noticepage";
    }


}
