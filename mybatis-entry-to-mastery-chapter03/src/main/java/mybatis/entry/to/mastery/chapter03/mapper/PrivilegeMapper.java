package mybatis.entry.to.mastery.chapter03.mapper;

import mybatis.entry.to.mastery.chapter03.mapper.provider.PrivilegeProvider;
import mybatis.entry.to.mastery.chapter03.model.SysPrivilege;
import org.apache.ibatis.annotations.SelectProvider;

public interface PrivilegeMapper {

    @SelectProvider(type = PrivilegeProvider.class, method = "selectById1")
    SysPrivilege selectById1(Long id);

    @SelectProvider(type = PrivilegeProvider.class, method = "selectById2")
    SysPrivilege selectById2(Long id);
}
