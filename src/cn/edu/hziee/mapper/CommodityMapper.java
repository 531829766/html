package cn.edu.hziee.mapper;

import cn.edu.hziee.model.Commodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CommodityMapper {
    public Commodity findByCommodityId(int id);
    public Commodity findByCommodity(   Commodity id);

    public List<Commodity> findByCommodityName(String commodity_name);

    public void insert(Commodity ct);

    public void delete(int id);

    public void update(Commodity ct);
    //分页

    //查询用户记录总数
    public int selectCommodityCount(HashMap<String, Object> map);

    //通过起始记录，和记录size放到一个hashMap再封装到List里

    public List<Commodity> findByCommodityPage(HashMap<String, Object> map);



}
