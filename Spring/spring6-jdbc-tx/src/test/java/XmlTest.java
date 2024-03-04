import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import xmltx.controller.BookController;

/**
 * ClassName:XmlTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/27 11:39
 * @Version 1.0
 */
@SpringJUnitConfig(locations = "classpath:beans-xml.xml")
public class XmlTest {
    @Autowired
    private BookController bookController;

    @Test
    public void testBuy(){
        bookController.buyBook(1,1);
    }
}
