import com.spring.validator.two.MyValidator1;
import com.spring.validator.two.MyValidator2;
import com.spring.validator.two.User;
import com.spring.validator.two.ValidatorConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {

    @Test
    public void testValidationOne() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ValidatorConfig.class);
        MyValidator1 validation1 = context.getBean(MyValidator1.class);

        User user = new User();
        user.setName("lucy");
        user.setAge(20);
        boolean message = validation1.validatorByUserOne(user);
        System.out.println(message);
    }

    @Test
    public void testValidationTwo() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ValidatorConfig.class);
        MyValidator2 validation2 = context.getBean(MyValidator2.class);

        User user = new User();
        user.setName("lucy");
        user.setAge(200);

        boolean message = validation2.validatorByUserTwo(user);
        System.out.println(message);

    }
}
