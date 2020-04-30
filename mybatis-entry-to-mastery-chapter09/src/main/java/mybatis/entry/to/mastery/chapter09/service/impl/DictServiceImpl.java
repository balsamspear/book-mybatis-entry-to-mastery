package mybatis.entry.to.mastery.chapter09.service.impl;

import mybatis.entry.to.mastery.chapter09.mapper.DictMapper;
import mybatis.entry.to.mastery.chapter09.model.SysDict;
import mybatis.entry.to.mastery.chapter09.service.DictService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public SysDict findById(Long id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    public List<SysDict> findBySysDict(SysDict sysDict, Integer offset, Integer limit) {
        RowBounds rowBounds = RowBounds.DEFAULT;
        if(offset != null && limit != null){
            rowBounds = new RowBounds(offset, limit);
        }
        return dictMapper.selectBySysDict(sysDict, rowBounds);
    }

    @Override
    public boolean saveOrUpdate(SysDict sysDict) {
        if(sysDict.getId() == null){
            return dictMapper.insert(sysDict) == 1;
        } else {
            return dictMapper.updateById(sysDict) == 1;
        }
    }

    @Override
    public boolean deleteById(Long id) {
    	if(id == null){
    		throw new NullPointerException("id");
    	}
        return dictMapper.deleteById(id) == 1;
    }
}