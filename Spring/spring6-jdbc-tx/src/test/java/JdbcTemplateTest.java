import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.swing.*;
import java.util.List;
import java.util.Map;

/**
 * ClassName:JdbcTemplateTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/26 17:59
 * @Version 1.0
 */
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Test
    public void testUpdate(){
        // //1 添加操作
        // // 第一步 编写sql语句
        // String sql = """
        //             insert into t_emp
        //             values(null,?,?,?)
        //             """;
        // // 第二步 调用jdbcTemplate的方法，传入相关参数
        // int rows = jdbcTemplate.update(sql, "kangna", 16, "女");
        // System.out.println(rows);

        // //2 修改操作
        // String sql = """
        //             update t_emp
        //             set age = ?
        //             where id = ?
        //             """;
        // int rows = jdbcTemplate.update(sql, 20,2);
        // System.out.println(rows);

        //3 删除操作
        String sql = """
                    delete from t_emp
                    where id =?
                    """;
        int rows = jdbcTemplate.update(sql, 2);
        System.out.println(rows);
    }
}
