package cn.edu.hziee.service;

import cn.edu.hziee.mapper.RecordMapper;
import cn.edu.hziee.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecordService {
    @Autowired
    private RecordMapper recordMapper;

    public int insertRecord(Record record){ return this.recordMapper.insertRecord(record);}
    public List<Record> findRecordByUid(int l_uid){ return  this.recordMapper.findRecordByUid(l_uid);}
    public int findMaxRid(){return this.recordMapper.findMaxRid();}
    public Record findRecordByRid(int rid){return this.recordMapper.findRecordByRid(rid);}
}
