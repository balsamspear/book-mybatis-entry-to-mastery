import mybatis.entry.to.mastery.chapter02.MyMapperProxy;
import mybatis.entry.to.mastery.chapter02.mapper.UserMapper;
import mybatis.entry.to.mastery.chapter02.model.SysRole;
import mybatis.entry.to.mastery.chapter02.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.List;

public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById001() {
        try (SqlSession sqlSession = getSqlSession()) {
            SysUser sysUser = sqlSession.selectOne("mybatis.entry.to.mastery.chapter02.mapper.UserMapper.selectById", 1);
            System.out.println(sysUser);
        }
    }

    @Test
    public void testSelectById002() {
        try (SqlSession sqlSession = getSqlSession()) {
            //SysUser sysUser = sqlSession.selectOne("com.balsam.chapter02.mapper.UserMapper.selectById", 1);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectById(1L);
            System.out.println(sysUser);
        }
    }

    @Test
    public void testSelectAll1() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> sysUserList = userMapper.selectAll1();
            System.out.println(sysUserList);
        }
    }

    /**
     * 自动映射 mapUnderscoreToCamelCase，自动将以下画线方式命名的数据库列映射到 Java 对象驼峰式命名属性中
     * <p>
     * 在 mybatis-config.xml 中配置
     * <settings>
     * <setting name="mapUnderscoreToCamelCase" value="true" />
     * </settings>
     */
    @Test
    public void testSelectAll2() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> sysUserList = userMapper.selectAll2();
            System.out.println(sysUserList);
        }
    }

    @Test
    public void testSelectRoleByUserId() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> sysRoleList = userMapper.selectRoleByUserId(1L);
            System.out.println(sysRoleList);
        }
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个 user 对象
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            //正常情况下应该读入一张图片存到 byte 数组中
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            //将新建的对象插入数据库中，特别注意，这里的返回值 result 是执行的 SQL 影响的行数
            int result = userMapper.insert(user);
            //只插入 1 条数据
            Assert.assertEquals(1, result);
            //id 为 null，我们没有给 id 赋值，并且没有配置回写 id 的值
            Assert.assertNull(user.getId());
        } finally {
            //为了不影响数据库中的数据导致其他测试失败，这里选择回滚
            //由于默认的 sqlSessionFactory.openSession() 是不自动提交的，
            //因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insert2(user);
            //只插入 1 条数据
            Assert.assertEquals(1, result);
            // 因为 id 回写，所以 id 不为 null
            Assert.assertNotNull(user.getId());
        } finally {
            sqlSession.rollback();
            //不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testInsert3() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insert3(user);
            //只插入 1 条数据
            Assert.assertEquals(1, result);
            // 因为 id 回写，所以 id 不为 null
            Assert.assertNotNull(user.getId());
        } finally {
            sqlSession.rollback();
            //不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //从数据库查询 1 个 user 对象
            SysUser user = userMapper.selectById(1L);
            //当前 userName 为 admin
            Assert.assertEquals("admin", user.getUserName());
            //修改用户名
            user.setUserName("admin_test");
            //修改邮箱
            user.setUserEmail("test@mybatis.tk");
            //更新数据，特别注意，这里的返回值 result 是执行的 SQL 影响的行数
            int result = userMapper.updateById(user);
            //只更新 1 条数据
            Assert.assertEquals(1, result);
            //根据当前 id 查询修改后的数据
            user = userMapper.selectById(1L);
            //修改后的名字 admin_test
            Assert.assertEquals("admin_test", user.getUserName());
        } finally {
            //为了不影响数据库中的数据导致其他测试失败，这里选择回滚
            //由于默认的 sqlSessionFactory.openSession() 是不自动提交的，
            //因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //从数据库查询 1 个 user 对象，根据 id = 1 查询
            SysUser user1 = userMapper.selectById(1L);
            //现在还能查询出 user 对象
            Assert.assertNotNull(user1);
            //调用方法删除
            Assert.assertEquals(1, userMapper.deleteById(1L));
            //再次查询，这时应该没有值，为 null
            Assert.assertNull(userMapper.selectById(1L));

            //使用 SysUser 参数再做一遍测试，根据 id = 1001  查询
            SysUser user2 = userMapper.selectById(1001L);
            //现在还能查询出 user 对象
            Assert.assertNotNull(user2);
            //调用方法删除，注意这里使用参数为 user2
            Assert.assertEquals(1, userMapper.deleteById(user2));
            //再次查询，这时应该没有值，为 null
            Assert.assertNull(userMapper.selectById(1001L));
            //使用 SysUser 参数再做一遍测试
        } finally {
            //为了不影响数据库中的数据导致其他测试失败，这里选择回滚
            //由于默认的 sqlSessionFactory.openSession() 是不自动提交的，
            //因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled(){
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用 selectRolesByUserIdAndRoleEnabled 方法查询用户的角色
            List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
            //结果不为空
            Assert.assertNotNull(roleList);
            //角色数量大于 0 个
            Assert.assertTrue(roleList.size() > 0);
        }
    }

    @Test
    public void testMyMapperProxy() {
        try (SqlSession sqlSession = getSqlSession()) {
            MyMapperProxy<UserMapper> mapperHandler = new MyMapperProxy<>(UserMapper.class, sqlSession);
            UserMapper instance = (UserMapper) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{UserMapper.class}, mapperHandler);
            List<SysUser> userList = instance.selectAll1();
            System.out.println(userList);
        }
    }
}
