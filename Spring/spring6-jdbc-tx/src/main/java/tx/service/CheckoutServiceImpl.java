package tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:CheckoutServiceImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/27 10:09
 * @Version 1.0
 */
@Service
public class CheckoutServiceImpl implements CheckoutService{

    @Autowired
    private BookService bookService;

    @Transactional
    @Override
    public void checkout(Integer[] bookIds,Integer userId) {
        for (Integer bookId: bookIds) {
            bookService.buyBook(bookId, userId);
        }
    }
}
