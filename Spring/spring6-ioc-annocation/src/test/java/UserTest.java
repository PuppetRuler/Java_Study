import com.spring.junit.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:UserTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 17:43
 * @Version 1.0
 */
public class UserTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User)context.getBean("user");
        System.out.println(user);
    }
}
