import com.spring.aop.example.Calculator;
import com.spring.aop.example.CalculatorImpl;
import com.spring.aop.example.ProxyFactory;

public class CalTest {

    public static void main(String[] args) {
        //创建代理对象（动态）
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        proxy.add(1,2);
        // proxy.mul(2,4);
    }
}
