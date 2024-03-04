import com.mybatis.mapper.CustomerMapper;
import com.mybatis.mapper.OrderMapper;
import com.mybatis.pojo.Customer;
import com.mybatis.pojo.Order;
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
 * @Create 2024/2/29 19:22
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
    public void end(){
        sqlSession.close();
    }

    /**
     * 根据订单id关联用户对象
     */
    @Test
    public void testToOne(){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderById(1);
        System.out.println(order);
        System.out.println(order.getCustomer());
    }

    @Test
    public void testToMany(){
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.queryList();
        System.out.println("customers:"+customers);
        for (Customer customer: customers){
            List<Order> orderList = customer.getOrderList();
            System.out.println("orderList:"+orderList);
        }
    }
}
