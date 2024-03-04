package tx.dao;

/**
 * ClassName:BookDao
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/26 21:12
 * @Version 1.0
 */
public interface BookDao {

    /**
     * 更新图书id查询图书价格
     * @param bookId
     * @return
     */
    Integer getBookPriceByBookId(Integer bookId);

    /**
     * 更新图书库存 -1
     * @param bookId
     */
    void updateStock(Integer bookId);

    /**
     * 更新用户表用户余额 - 图书价格
     * @param userId
     * @param price
     */
    void updateUserBalance(Integer userId, Integer price);
}
