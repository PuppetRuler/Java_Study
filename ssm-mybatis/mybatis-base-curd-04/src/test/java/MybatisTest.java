import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName:MybatisTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/29 13:35
 * @Version 1.0
 */
public class MybatisTest {

    SqlSession sqlSession;

    @BeforeEach // 在测试方法之前自动调用
    public void before() throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @AfterEach // 在测试方法之后自动调用
    public void clean(){
        sqlSession.close();
    }

    @Test
    public void testInsert() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("栞那");
        user.setPassword("123456");
        int rows = userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    public void testUpdate(){

    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testSelectById(){

    }

    @Test
    public void testSelectAll(){

    }
}
