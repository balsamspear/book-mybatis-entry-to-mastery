package mybatis.entry.to.mastery.chapter08.mapper;

import mybatis.entry.to.mastery.chapter08.model.SysRole;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface RoleMapper {

    List<SysRole> selectAll();

    List<SysRole> selectAll(RowBounds rowBounds);
}
