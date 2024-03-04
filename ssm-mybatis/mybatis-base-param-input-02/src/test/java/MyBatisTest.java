import com.mybatis.mapper.EmployeeMapper;
import com.mybatis.mapper.TeacherMapper;
import com.mybatis.pojo.Employee;
import com.mybatis.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description:
 */
public class MyBatisTest {

    @Test
    public void test_01() throws IOException {

        //1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //3.获取SqlSession对象 【自动开启 JDBC】
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.获取代理mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.queryById(1);
        // 主键回显
        System.out.println(employee.getEmpId());

        System.out.println("employee = " + employee);

        //5.管理资源或者提交事务
        sqlSession.close();
    }

    @Test
    public void test_02() throws IOException {

        //1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //3.获取SqlSession对象 【自动开启 JDBC】
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.获取代理mapper对象
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = new Teacher();
        teacher.setTName("ciallo");

        teacherMapper.insertTeacher(teacher);

        //5.管理资源或者提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
