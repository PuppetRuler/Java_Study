package tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * ClassName:BookDaoImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/26 21:12
 * @Version 1.0
 */
@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getBookPriceByBookId(Integer bookId) {
        String sql = """
                    select price
                    from t_book
                    where book_id = ?
                    """;
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
        return price;
    }

    @Override
    public void updateStock(Integer bookId) {
        String sql = """
                    update t_book
                    set stock = stock - 1
                    where book_id = ?
                    """;
        jdbcTemplate.update(sql, bookId);
    }

    @Override
    public void updateUserBalance(Integer userId, Integer price) {
        String sql = """
                    update t_user
                    set balance = balance - ?
                    where user_id = ?
                    """;
        jdbcTemplate.update(sql, price, userId);
    }
}
