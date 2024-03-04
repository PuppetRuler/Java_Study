import com.spring.junit.AnnotationApplicationContext;
import com.spring.service.UserService;
import org.junit.jupiter.api.Test;

/**
 * ClassName:UserTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/26 13:52
 * @Version 1.0
 */
public class UserTest {
    @Test
    public void test(){
        AnnotationApplicationContext context = new AnnotationApplicationContext("com.spring");
        UserService userService = (UserService) context.getBean(UserService.class);
        userService.add();
    }

}
