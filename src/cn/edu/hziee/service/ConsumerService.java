package cn.edu.hziee.service;

import cn.edu.hziee.mapper.ConsumerMapper;
import cn.edu.hziee.model.Consumer;
import cn.edu.hziee.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class ConsumerService {

    @Autowired

    private ConsumerMapper consumerMapper;

    public int register(Consumer consumer){
        return this.consumerMapper.insertConsumer(consumer);
    }

    public Consumer findConsumerById(int id){
        return this.consumerMapper.findConsumerById(id);
    }

    public Consumer findConsumerByIdName(String username) {
        return this.consumerMapper.findConsumerByIdName(username);
    }

    public void updateUserBalanceByUid(Consumer consumer){this.consumerMapper.updateUserBalanceByUid(consumer);}

    public void addConsumer(Consumer ct){
        this.consumerMapper.insert(ct);
    }

    public void delete(int id){

        this.consumerMapper.delete(id);

    }

    public List<Consumer> findByCommodityName(String name){

        return this.consumerMapper.findByConsumerName(name);

    }

    public Consumer findByConsumerId(int id) {
        return this.consumerMapper.findConsumerById(id);
    }

    public void update(Consumer ct){

        this.consumerMapper.update(ct);

    }


    //分页数据
    public Page<Consumer> findByConsumerPage(int currentPage, HashMap<String, Object> params) {

        HashMap<String, Object> consumermap = new HashMap<String, Object>();

        Page<Consumer> consumerpage = new Page<Consumer>();

        //封装当前页数

        consumerpage.setCurrPage(currentPage);

        //每页显示的数据

        int pageSize = 4;//当前总共是9条，那么可以计算得到3页数据

        consumerpage.setPageSize(pageSize);

        //封装带条件查询的总记录数

        int totalCount = consumerMapper.selectConsumerCount(params);

        consumerpage.setTotalCount(totalCount);

        //封装总页数

        Integer totalcount = totalCount;

        //计算页数，如果整除，那么直接返回冒号左边的值，否则还需要加1

        Integer num = totalcount%pageSize==0? totalcount / pageSize: totalcount / pageSize+1;

        consumerpage.setTotalPage(num.intValue());//转换为整数

        consumermap.put("start", (currentPage - 1) * pageSize);//起始的记录值

        consumermap.put("size", consumerpage.getPageSize());//获取每个页面的pageSize

        consumermap.put("username",params.get("username"));

        consumermap.put("balance",params.get("balance"));

        //  map.put("查询条件参数",查询值)   如果后面要做带查询条件的分页，可以在这里添加查询参数，而查询条件参数可以在当前findByPage的方法里加一个参数

        List<Consumer> list = consumerMapper.findByConsumerPage(consumermap);

        consumerpage.setList(list);

        return consumerpage;

    }

}
