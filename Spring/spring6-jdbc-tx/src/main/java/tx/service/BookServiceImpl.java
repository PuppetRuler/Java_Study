package tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tx.dao.BookDao;

/**
 * ClassName:BookServiceImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/26 21:12
 * @Version 1.0
 */
// @Transactional(readOnly = true)  只可查询
// @Transactional(timeout = 3)  超时
// @Transactional(noRollbackFor = ArithmeticException.class)    设置某异常不进行回滚
// @Transactional(isolation = Isolation.DEFAULT)    //使用数据库默认的隔离级别
@Transactional(propagation = Propagation.REQUIRED) // 默认事务行为 有就加入，没有就新建
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;

    // 买书的方法
    @Override
    public int buyBook(Integer bookId, Integer userId) {
        // 更新图书id查询图书价格
        Integer price = bookDao.getBookPriceByBookId(bookId);

        // 更新图书库存 -1
        bookDao.updateStock(bookId);

        // 更新用户表用户余额 - 图书价格
        bookDao.updateUserBalance(userId, price);
        return 0;
    }
}
