package cn.edu.hziee.mapper;

import cn.edu.hziee.model.Consumer;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ConsumerMapper {
    public Consumer findConsumerById(int id);

    public  int insertConsumer(Consumer consumer);

    public Consumer findConsumerByIdName(String username);

    public List<Consumer> findByConsumerName(String consumer_name);
   // http://localhost:8080/sss_war_exploded/login2
    public void updateUserBalanceByUid(Consumer consumer);

    public void insert(Consumer cn);

    public void delete(int id);

    public void update(Consumer cn);
    //分页

    //查询用户记录总数
    public int selectConsumerCount(HashMap<String, Object> map);

    //通过起始记录，和记录size放到一个hashMap再封装到List里

    public List<Consumer> findByConsumerPage(HashMap<String, Object> map);

}
