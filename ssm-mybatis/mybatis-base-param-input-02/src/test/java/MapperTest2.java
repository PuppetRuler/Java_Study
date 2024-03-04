import com.mybatis.mapper.EmployeeMapper;
import com.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

/**
 * ClassName:MapperTest2
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/28 14:44
 * @Version 1.0
 */
public class MapperTest2 {

    @Test
    public void testMapper() throws Exception {
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.queryById(1);
        System.out.println(employee);
        // 关闭事务
        sqlSession.close();
    }
}
