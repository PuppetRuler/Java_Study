package xmltx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmltx.dao.BookDao;

/**
 * ClassName:BookServiceImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/26 21:12
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    // 买书的方法
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // 更新图书id查询图书价格
        Integer price = bookDao.getBookPriceByBookId(bookId);

        // 更新图书库存 -1
        bookDao.updateStock(bookId);

        // 更新用户表用户余额 - 图书价格
        bookDao.updateUserBalance(userId, price);
    }
}
