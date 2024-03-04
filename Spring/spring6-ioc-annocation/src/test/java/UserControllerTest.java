import com.spring.resource.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:UserControllerTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 21:35
 * @Version 1.0
 */
public class UserControllerTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController controller = context.getBean(UserController.class);
        controller.add();
    }
}
