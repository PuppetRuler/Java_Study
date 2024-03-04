import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @Create 2024/3/1 14:17
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
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        PageHelper.startPage(1,2);
        List<Employee> employeeList = employeeMapper.queryList();

        //将查询数据封装到一个PageInfo的分页实体类 (一共有多少页,一共有多少条等等)
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList);

        // pageInfo获取分页数据

        //  TODO: 注意不能将两条查询装到一个分页区

        // 当前页的数据
        List<Employee> employeeList1 = pageInfo.getList();

        // 获取总页数
        int pages = pageInfo.getPages();
        System.out.println("pages = " + pages);
        // 获取总条数
        long total = pageInfo.getTotal();
        System.out.println("total = " + total);
        int pageNum = pageInfo.getPageNum();
        System.out.println("pageNum = " + pageNum);
        int pageSize = pageInfo.getPageSize();
        System.out.println("pageSize = " + pageSize);
    }

}
