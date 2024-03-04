package tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tx.service.BookService;
import tx.service.CheckoutService;

/**
 * ClassName:BookController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/26 21:12
 * @Version 1.0
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CheckoutService checkoutService;

    // 图书Id和用户Id
    public void buyBook(Integer bookId, Integer userId){
        // 调用买图书的方法
        int rows = bookService.buyBook(bookId, userId);
    }

    /**
     * 买多本书
     * @param bookIds
     * @param userId
     */
    public void checkoutBook(Integer[] bookIds,Integer userId){
        checkoutService.checkout(bookIds, userId);
    }
}
