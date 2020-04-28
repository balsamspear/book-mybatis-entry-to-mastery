import mybatis.entry.to.mastery.chapter03.mapper.RoleMapper;
import mybatis.entry.to.mastery.chapter03.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class RoleMapperTest extends BaseMapperTest {

    /**
     * 使用别名
     */
    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = roleMapper.selectById(1L);
            Assert.assertNotNull(sysRole);
            Assert.assertEquals("管理员", sysRole.getRoleName());
        }
    }

    /**
     * 配置了“下画线转驼峰”自动转换后，不需要显式别名
     */
    @Test
    public void testSelectById1() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = roleMapper.selectById1(1L);
            Assert.assertNotNull(sysRole);
            Assert.assertEquals("管理员", sysRole.getRoleName());
        }
    }

    /**
     * Results 注解（对应 XML 中的 ResultMap 标签）
     */
    @Test
    public void testSelectById2() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = roleMapper.selectById2(1L);
            Assert.assertNotNull(sysRole);
            Assert.assertEquals("管理员", sysRole.getRoleName());
        }
    }

    /**
     * 使用 ResultMap 注解引用 Results
     */
    @Test
    public void testSelectAll() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> sysRoleList = roleMapper.selectAll();
            // 不管有没有查到数据，List 都不会为 null
            Assert.assertNotNull(sysRoleList);
            Assert.assertTrue("没有数据", sysRoleList.size() > 0);
            Assert.assertNotNull(sysRoleList.get(0).getRoleName());
        }
    }

    @Test
    public void testInsert() {
        try (SqlSession sqlSession = getSqlSession()) {
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("超级管理员");
            sysRole.setEnabled(1);
            sysRole.setCreateBy(1L);
            sysRole.setCreateTime(new Date());
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            int insert = roleMapper.insert(sysRole);
            Assert.assertEquals(1, insert);
            Assert.assertNull(sysRole.getId());
            sqlSession.rollback();
        }
    }

    @Test
    public void testInsert2() {
        try (SqlSession sqlSession = getSqlSession()) {
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("超级管理员");
            sysRole.setEnabled(1);
            sysRole.setCreateBy(1L);
            sysRole.setCreateTime(new Date());
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            int insert = roleMapper.insert2(sysRole);
            Assert.assertEquals(1, insert);
            Assert.assertNotNull(sysRole.getId());
            sqlSession.rollback();
        }
    }

    @Test
    public void testInsert3() {
        try (SqlSession sqlSession = getSqlSession()) {
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("超级管理员");
            sysRole.setEnabled(1);
            sysRole.setCreateBy(1L);
            sysRole.setCreateTime(new Date());
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            int insert = roleMapper.insert3(sysRole);
            Assert.assertEquals(1, insert);
            Assert.assertNotNull(sysRole.getId());
            sqlSession.rollback();
        }
    }

    @Test
    public void testUpdateById(){
        //获取 sqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取 RoleMapper 接口
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            //由于数据库数据 enable 都是 1，所以我们给其中一个角色的 enable 赋值为 0
            SysRole role = roleMapper.selectById(2L);
            Assert.assertEquals(new Integer(1), role.getEnabled());
            role.setEnabled(0);
            roleMapper.updateById(role);
        } finally {
            sqlSession.rollback();
            //不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteById() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            int i = roleMapper.deleteById(1L);
            Assert.assertTrue(i > 0);
            SysRole sysRole = roleMapper.selectById(1L);
            Assert.assertNull(sysRole);
            sqlSession.rollback();
        }
    }
}
