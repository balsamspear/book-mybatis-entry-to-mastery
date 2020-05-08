import mybatis.entry.to.mastery.chapter08.mapper.RoleMapper;
import mybatis.entry.to.mastery.chapter08.mapper.UserMapper;
import mybatis.entry.to.mastery.chapter08.model.SysRole;
import mybatis.entry.to.mastery.chapter08.plugin.PageRowBounds;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class PluginTest extends BaseMapperTest {

    @Test
    public void testMapResult() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Map<String, Object>> list = userMapper.selectById(1L);
            list.forEach(System.out::println);
        }
    }

    @Test
    public void testSelectAllByRowBounds() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> list;
            // 查询前两个，使用 RowBounds 类型不会查询总数
            RowBounds rowBounds = new RowBounds(0, 1);
            list = roleMapper.selectAll(rowBounds);
            for (SysRole role : list) {
                System.out.println("角色名：" + role.getRoleName());
            }
            // 使用 PageRowBounds 会查询总数
            PageRowBounds pageRowBounds = new PageRowBounds(0, 1);
            list = roleMapper.selectAll(pageRowBounds);
            // 获取总数
            System.out.println("查询总数：" + pageRowBounds.getTotal());
            for (SysRole role : list) {
                System.out.println("角色名：" + role.getRoleName());
            }
            // 再次查询
            pageRowBounds = new PageRowBounds(1, 1);
            list = roleMapper.selectAll(pageRowBounds);
            // 获取总数
            System.out.println("查询总数：" + pageRowBounds.getTotal());
            for (SysRole role : list) {
                System.out.println("角色名：" + role.getRoleName());
            }
        }
    }
}
