package mybatis.entry.to.mastery.chapter04.mapper;

import mybatis.entry.to.mastery.chapter04.model.SysRole;
import mybatis.entry.to.mastery.chapter04.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    List<SysUser> selectByUser(SysUser sysUser);

    /**
     * 根据主键更新
     */
    int updateByIdSelective(SysUser sysUser);

    int insert4(SysUser sysUser);

    /**
     * 根据用户 id 或用户名查询
     */
    SysUser selectByIdOrUserName(SysUser sysUser);

    List<SysUser> selectByUser2(SysUser sysUser);

    /**
     * 根据主键更新
     */
    int updateByIdSelective2(SysUser sysUser);

    /**
     * 根据用户 id 集合查询
     */
    List<SysUser> selectByIdList(List<Long> idList);

    /**
     * 批量插入用户信息
     */
    int insertList(List<SysUser> userList);

    /**
     * 通过 Map 更新列
     */
    int updateByMap(Map<String, Object> map);

    List<SysUser> selectByUser3(SysUser sysUser);

    List<SysUser> selectByUser4(SysUser sysUser);

    List<SysUser> selectByUser5(SysUser sysUser);

    List<SysUser> selectByUser6(SysUser sysUser);
}
