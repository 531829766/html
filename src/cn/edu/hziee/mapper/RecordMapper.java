package cn.edu.hziee.mapper;

import cn.edu.hziee.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
@ResponseBody
public interface RecordMapper {

    public int insertRecord(Record record);
    public List<Record> findRecordByUid(int l_uid);
    public int findMaxRid();
    public Record findRecordByRid(int rid);
}
