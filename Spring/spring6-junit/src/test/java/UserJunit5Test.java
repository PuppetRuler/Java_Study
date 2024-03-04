import com.spring.junit.junit5.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * ClassName:UserJunit5Test
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/26 17:18
 * @Version 1.0
 */
//方式二
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")
//方式一
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class UserJunit5Test {
    @Autowired()
    private User user;

    @Test
    public void test(){
        System.out.println(user);
        user.run();
    }
}
