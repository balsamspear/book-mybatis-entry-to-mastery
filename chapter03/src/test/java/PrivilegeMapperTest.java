import com.balsam.chapter03.mapper.PrivilegeMapper;
import com.balsam.chapter03.model.SysPrivilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class PrivilegeMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById1() {
        try (SqlSession sqlSession = getSqlSession()) {
            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
            SysPrivilege sysPrivilege = privilegeMapper.selectById1(1L);
            Assert.assertNotNull(sysPrivilege);
            Assert.assertNotNull(sysPrivilege.getPrivilegeName());
        }
    }

    @Test
    public void testSelectById2() {
        try (SqlSession sqlSession = getSqlSession()) {
            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
            SysPrivilege sysPrivilege = privilegeMapper.selectById2(1L);
            Assert.assertNotNull(sysPrivilege);
            Assert.assertNotNull(sysPrivilege.getPrivilegeName());
        }
    }
}
