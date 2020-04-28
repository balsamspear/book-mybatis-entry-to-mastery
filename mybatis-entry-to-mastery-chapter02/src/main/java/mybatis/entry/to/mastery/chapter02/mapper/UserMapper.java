package mybatis.entry.to.mastery.chapter02.mapper;

import mybatis.entry.to.mastery.chapter02.model.SysRole;
import mybatis.entry.to.mastery.chapter02.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    SysUser selectById(Long id);

    /**
     * 手动映射
     */
    List<SysUser> selectAll1();

    /**
     * 自动映射 mapUnderscoreToCamelCase，自动将以下画线方式命名的数据库列映射到 Java 对象驼峰式命名属性中
     * <p>
     * 在 mybatis-config.xml 中配置
     * <settings>
     * <setting name="mapUnderscoreToCamelCase" value="true" />
     * </settings>
     */
    List<SysUser> selectAll2();

    List<SysRole> selectRoleByUserId(Long userId);

    int insert(SysUser sysUser);

    int insert2(SysUser sysUser);

    int insert3(SysUser sysUser);

    int updateById(SysUser sysUser);

    int deleteById(Long id);

    int deleteById(SysUser sysUser);

    /**
     * 根据用户 id 和 角色的 enabled 状态获取用户的角色
     */
    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId, @Param("enabled") Integer enabled);
}
