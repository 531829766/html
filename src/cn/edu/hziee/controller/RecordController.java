package cn.edu.hziee.controller;

import cn.edu.hziee.model.Commodity;
import cn.edu.hziee.model.Consumer;
import cn.edu.hziee.model.Record;
import cn.edu.hziee.service.ConsumerService;
import cn.edu.hziee.service.CommodityService;
import cn.edu.hziee.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
public class RecordController {


    @Autowired private CommodityService commodityService;
    @Autowired private RecordService recordService;
    @Autowired private ConsumerService consumerService;


//    添加购物记录，并调整商品库存,并调整用户优惠券库存
    @RequestMapping("addRecord")

    public int addRecord(int uid,int gid,int num,int scid){

//      调整商品库存
        Commodity commodity =new Commodity();
        commodity = commodityService.findByCommodityId(gid);
        System.out.println( commodity);
        commodity.setId(gid);
        int l1 = commodity.getStock();
        Commodity g2=new Commodity();
        for (int i = 0; i < l1; i++) {

            g2=commodityService.findByCommodityId(i);
            System.out.println("商品为："+g2);
        }
        double price=commodity.getOriginal();
        System.out.println(price);
//      调整用户余额
        Consumer c4=consumerService.findConsumerById(uid);
        System.out.println("用户为："+c4);


        double shiji=c4.getBalance()-price*num;
        System.out.println(shiji+"="+c4.getBalance()+"-"+price+"*"+num);
        c4.setBalance(shiji);
        System.out.println("更改后用户为："+c4);
        consumerService.updateUserBalanceByUid(c4);

        if(g2.getStock()>=num) {
            int cha = g2.getStock() - num;
            System.out.println("数量：" + cha);
            g2.setStock(cha);
            System.out.println("修改后："+g2);
           commodityService.update(g2);


//        插入记录
            Date date = new Date();
            SimpleDateFormat bartDateFormat = new SimpleDateFormat
                    ("yyyy-MM-dd");
            String day = bartDateFormat.format(date);
            Record r1 = new Record();

            r1.setL_uid(uid);
            r1.setL_gid(gid);
            r1.setGnumber(num);
            r1.setDate_time(day);

            int rows = recordService.insertRecord(r1);
            if (rows > 0) {
                System.out.println("成功插入：" + r1);
            } else {
                System.out.println("插入失败");
            }

            return recordService.findMaxRid();
        }else {return -1;}
    }

//    显示该用户的购买记录
    @RequestMapping("showRecord")

    public List<Record> showRecord(int l_uid){



        List<Record> l1= recordService.findRecordByUid(l_uid);
        return l1;
    }



//查找订单
    @RequestMapping("findRecordByRid")

    public Record findRecordByRid(int rid){
        Record r1=new Record();
        r1=recordService.findRecordByRid(rid);

        return r1;

    }

}
