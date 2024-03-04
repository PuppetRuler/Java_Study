import com.spring.autowire.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:AutowireTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 17:58
 * @Version 1.0
 */
public class AutowireTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController controller = context.getBean(UserController.class);
        controller.addUser();
    }
}
