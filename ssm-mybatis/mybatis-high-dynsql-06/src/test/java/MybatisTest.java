import com.mybatis.mapper.EmployeeMapper;
import com.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * ClassName:MybatisTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/1 2:36
 * @Version 1.0
 */
public class MybatisTest {
    private SqlSession sqlSession;

    @BeforeEach
    public void start() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(
                        Resources.getResourceAsStream("mybatis-config.xml"));
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @AfterEach
    public void end() {
        sqlSession.close();
    }
    
    @Test
    public void test(){
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> query = mapper.query(null, 101.0);
        System.out.println(query);
    }
}
