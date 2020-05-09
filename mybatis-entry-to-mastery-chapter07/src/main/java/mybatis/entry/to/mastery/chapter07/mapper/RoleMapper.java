package mybatis.entry.to.mastery.chapter07.mapper;


import mybatis.entry.to.mastery.chapter07.model.SysRole;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.caches.ehcache.EhcacheCache;
import org.mybatis.caches.redis.RedisCache;

@CacheNamespace(implementation = RedisCache.class)
public interface RoleMapper {

    @Select("select id, role_name roleName, enabled, create_by createBy, create_time createTime from sys_role where id = #{id}")
    SysRole selectById(Long id);

    @Update({"update sys_role",
            "set role_name = #{roleName},",
            "enabled = #{enabled},",
            "create_by = #{createBy},",
            "create_time = #{createTime, jdbcType=TIMESTAMP}",
            "where id = #{id}"
    })
    int updateById(SysRole sysRole);
}
