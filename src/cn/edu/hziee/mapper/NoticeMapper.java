package cn.edu.hziee.mapper;

import cn.edu.hziee.model.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface NoticeMapper {
    public Notice findByNoticeId(int id);

    public List<Notice> findByNoticeName(String title);

    public void insert(Notice nt);

    public void delete(int nt);

    public void update(Notice nt);
    //分页

    //查询用户记录总数
    public int selectNoticeCount(HashMap<String, Object> map);

    //通过起始记录，和记录size放到一个hashMap再封装到List里

    public List<Notice> findByNoticePage(HashMap<String, Object> map);

}