package mybatis.entry.to.mastery.chapter09.service;

import mybatis.entry.to.mastery.chapter09.model.SysDict;

import java.util.List;

public interface DictService {

    SysDict findById(Long id);

    List<SysDict> findBySysDict(SysDict sysDict, Integer offset, Integer limit);

    boolean saveOrUpdate(SysDict sysDict);

    boolean deleteById(Long id);
}