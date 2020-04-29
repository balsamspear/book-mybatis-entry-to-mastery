package mybatis.entry.to.mastery.chapter07.mapper;


import mybatis.entry.to.mastery.chapter07.model.SysUser;

public interface UserMapper {

    SysUser selectById(Long id);

    SysUser selectByIdNoCache(Long id);

    int deleteById(Long id);

    /**
     * 根据用户 id 获取用户信息和用户的角色信息
     */
    SysUser selectUserAndRoleById(Long id);
}
