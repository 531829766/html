package cn.edu.hziee.service;

import cn.edu.hziee.mapper.NoticeMapper;
import cn.edu.hziee.model.Notice;
import cn.edu.hziee.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;


    public void addNotice(Notice ct){
        this.noticeMapper.insert(ct);
    }

    public void delete(int id){

        this.noticeMapper.delete(id);

    }

    public List<Notice> findByNoticeName(String name){

        return this.noticeMapper.findByNoticeName(name);

    }

    public Notice findByNoticeId(int id) {
        return this.noticeMapper.findByNoticeId(id);
    }

    public void update(Notice ct){

        this.noticeMapper.update(ct);

    }


    //分页数据
    public Page<Notice> findByNoticePage(int currentPage, HashMap<String, Object> params) {

        HashMap<String, Object> noticemap = new HashMap<String, Object>();

        Page<Notice> noticepage = new Page<Notice>();

        //封装当前页数

        noticepage.setCurrPage(currentPage);

        //每页显示的数据

        int pageSize = 4;//当前总共是9条，那么可以计算得到3页数据

        noticepage.setPageSize(pageSize);

        //封装带条件查询的总记录数

        int totalCount = noticeMapper.selectNoticeCount(params);

        noticepage.setTotalCount(totalCount);

        //封装总页数

        Integer totalcount = totalCount;

        //计算页数，如果整除，那么直接返回冒号左边的值，否则还需要加1

        Integer num = totalcount%pageSize==0? totalcount / pageSize: totalcount / pageSize+1;

        noticepage.setTotalPage(num.intValue());//转换为整数

        noticemap.put("start", (currentPage - 1) * pageSize);//起始的记录值

        noticemap.put("size", noticepage.getPageSize());//获取每个页面的pageSize

        noticemap.put("commodity_name",params.get("commodity_name"));

        noticemap.put("original",params.get("original"));


        //  map.put("查询条件参数",查询值)   如果后面要做带查询条件的分页，可以在这里添加查询参数，而查询条件参数可以在当前findByPage的方法里加一个参数

        List<Notice> list = noticeMapper.findByNoticePage(noticemap);

        noticepage.setList(list);

        return noticepage;

    }
}
