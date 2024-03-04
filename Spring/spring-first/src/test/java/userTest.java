import com.spring.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:userTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/24 21:32
 * @Version 1.0
 */
public class userTest {
    // 创建logger对象
    private Logger logger = LoggerFactory.getLogger(userTest.class);

    @Test
    public void testUserObject(){
        // 加载spring配置文件，对象创建
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        // 获取创建对象
        User user = (User)context.getBean("user");

        // 使用对象调用方法进行测试
        user.add();

        // 手动写入日志
        logger.info("@@@执行成功");
    }
}
