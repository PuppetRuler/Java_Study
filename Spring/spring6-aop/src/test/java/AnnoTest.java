import com.spring.aop.annoaop.Calculator;
import com.spring.aop.annoaop.CalculatorImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:AnnoTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/26 16:01
 * @Version 1.0
 */
public class AnnoTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.add(2,4);
    }
}
