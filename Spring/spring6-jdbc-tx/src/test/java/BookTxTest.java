import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import tx.controller.BookController;

/**
 * ClassName:BookTxTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/26 21:47
 * @Version 1.0
 */
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class BookTxTest {
    @Autowired
    private BookController bookController;
    
    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
    }
}
