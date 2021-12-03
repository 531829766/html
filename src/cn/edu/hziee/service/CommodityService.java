package cn.edu.hziee.service;

import cn.edu.hziee.mapper.CommodityMapper;
import cn.edu.hziee.model.Commodity;
import cn.edu.hziee.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
@Service
@Transactional
public class CommodityService {
    @Autowired

    private CommodityMapper commodityMapper;

    public void addCommodity(Commodity ct){
        this.commodityMapper.insert(ct);
    }

    public void delete(int id){

        this.commodityMapper.delete(id);

    }

    public List<Commodity> findByCommodityName(String name){

        return this.commodityMapper.findByCommodityName(name);

    }

    public Commodity findByCommodityId(int id) {
        return this.commodityMapper.findByCommodityId(id);
    }
    public Commodity findByCommodity(Commodity ct) {
        return this.commodityMapper.findByCommodity(ct);
    }

    public void update(Commodity ct){

        this.commodityMapper.update(ct);

    }


    //分页数据
    public Page<Commodity> findByCommodityPage(int currentPage, HashMap<String, Object> params) {

        HashMap<String, Object> commoditymap = new HashMap<String, Object>();

        Page<Commodity> commoditypage = new Page<Commodity>();

        //封装当前页数

        commoditypage.setCurrPage(currentPage);

        //每页显示的数据

        int pageSize = 4;//当前总共是9条，那么可以计算得到3页数据

        commoditypage.setPageSize(pageSize);

        //封装带条件查询的总记录数

        int totalCount = commodityMapper.selectCommodityCount(params);

        commoditypage.setTotalCount(totalCount);

        //封装总页数

        Integer totalcount = totalCount;

        //计算页数，如果整除，那么直接返回冒号左边的值，否则还需要加1

        Integer num = totalcount%pageSize==0? totalcount / pageSize: totalcount / pageSize+1;

        commoditypage.setTotalPage(num.intValue());//转换为整数

        commoditymap.put("start", (currentPage - 1) * pageSize);//起始的记录值

        commoditymap.put("size", commoditypage.getPageSize());//获取每个页面的pageSize

        commoditymap.put("commodity_name",params.get("commodity_name"));

        commoditymap.put("original",params.get("original"));

        commoditymap.put("discount",params.get("discount"));

        commoditymap.put("stock",params.get("stock"));

        commoditymap.put("commodity_type",params.get("commodity_type"));

        commoditymap.put("headmaster",params.get("headmaster"));

        //  map.put("查询条件参数",查询值)   如果后面要做带查询条件的分页，可以在这里添加查询参数，而查询条件参数可以在当前findByPage的方法里加一个参数

        List<Commodity> list = commodityMapper.findByCommodityPage(commoditymap);

        commoditypage.setList(list);

        return commoditypage;

    }
}
