package cn.edu.hziee.controller;

import cn.edu.hziee.service.CommodityService;
import cn.edu.hziee.util.Page;
import cn.edu.hziee.model.Commodity;
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
public class CommodityController {
    @Autowired
    private CommodityService commodityService;



    @RequestMapping("commoditylist")
    public String commoditytoList(Model model){
        List<Commodity> list = commodityService.findByCommodityName("李");
        System.out.println(list);
        model.addAttribute("commoditylist",list);//将数据库查询的数据传递到页面用JSTL、EL进行显示
        return "commoditylist";
    }

    @RequestMapping("commodityto_add")
    public String commoditytoAdd() {
        return "commodityadd";
    }

    @RequestMapping("commodityadd")
    public String commodityadd(Commodity ct) {

        commodityService.addCommodity(ct);

        return "redirect:commoditypage";

    }


    @RequestMapping("commoditydelete")

    public String commoditydelete(int[] ids) {

        if (ids != null) {//批量删除

            for (int id : ids) {

                System.out.println("删除班级id==" + id);

                commodityService.delete(id);

            }

        }

        return "redirect:commoditypage";

    }

    @RequestMapping("commoditydelete/{id}")
    public String commoditydelete(@PathVariable int id) {

        System.out.println("删除班级id==" + id);

        commodityService.delete(id);

        return "redirect:/commoditypage"; //这里的/page不要写成page，否则会出现路径错误

    }

    @RequestMapping(value = "commodityedit/{id}",method = RequestMethod.GET)
    public String commodityedit(@PathVariable int id, Model model) {

        Commodity ct = commodityService.findByCommodityId(id);//从数据库找到id对应的对象

        model.addAttribute("commoditydata",ct);//通过model传递到页面上去

        return "commodityedit";

    }

    @RequestMapping(value = "commodityedit",method = RequestMethod.POST)
    public String commodityedit(Commodity ct) {

        commodityService.update(ct);

        return "redirect:commoditypage";//重定向到分页数据显示

    }

    //分页查询
    @RequestMapping("commoditypage")
    public String commoditygetPage(@RequestParam(defaultValue = "1") int currentPage, Model model,
                               HttpServletRequest request,
                                   String picture, String commodity_name,
                                   Integer original, Integer discount,
                                   Integer stock, String commodity_type) {

        HashMap<String, Object> commoditymap = new HashMap<String, Object>();
        HashMap<String, Object> shoppingmap = new HashMap<String, Object>();

        commoditymap.put("picture", picture);

        commoditymap.put("commodity_name", commodity_name);

        commoditymap.put("original", original);

        commoditymap.put("discount", discount);

        commoditymap.put("stock", stock);

        commoditymap.put("commodity_type", commodity_type);

        shoppingmap.put("picture", picture);

        shoppingmap.put("commodity_name", commodity_name);

        shoppingmap.put("original", original);

        shoppingmap.put("discount", discount);

        shoppingmap.put("stock", stock);

        shoppingmap.put("commodity_type", commodity_type);

        Page<Commodity> commoditypage = commodityService.findByCommodityPage(currentPage, commoditymap);
        Page<Commodity> shopping = commodityService.findByCommodityPage(currentPage, commoditymap);

        model.addAttribute("commoditypageData", commoditypage);//设置一个属性
        model.addAttribute("shoppingData", shopping);//设置一个属性

        model.addAttribute("commodityparams", commoditymap);
        model.addAttribute("shoppingparams", shoppingmap);

        return "commoditypage";
    }
    @RequestMapping("shopping")
    public String shopgetPage(@RequestParam(defaultValue = "1") int currentPage, Model model,
                                   HttpServletRequest request,
                                   String picture, String commodity_name,
                                   Integer original, Integer discount,
                                   Integer stock, String commodity_type) {

        HashMap<String, Object> shoppingmap = new HashMap<String, Object>();


        shoppingmap.put("picture", picture);

        shoppingmap.put("commodity_name", commodity_name);

        shoppingmap.put("original", original);

        shoppingmap.put("discount", discount);

        shoppingmap.put("stock", stock);

        shoppingmap.put("commodity_type", commodity_type);

        Page<Commodity> shopping = commodityService.findByCommodityPage(currentPage, shoppingmap);

        model.addAttribute("shoppingData", shopping);//设置一个属性

        model.addAttribute("shoppingparams", shoppingmap);

        return "shopping";
    }
}
