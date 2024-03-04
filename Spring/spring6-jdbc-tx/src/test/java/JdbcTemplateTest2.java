import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import tx.controller.BookController;

import java.util.List;

/**
 * ClassName:JdbcTemplateTest2
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/26 18:34
 * @Version 1.0
 */
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class JdbcTemplateTest2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询方法

    // 返回对象
    @Test
    public void testSelectObject(){
        // 写法一：
        // String sql = """
        //             select *
        //             from t_emp
        //             where id = ?
        //             """;
        // Emp empResult = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
        //     Emp emp = new Emp();
        //     emp.setId(rs.getInt("id"));
        //     emp.setName(rs.getString("name"));
        //     emp.setAge(rs.getInt("age"));
        //     emp.setSex(rs.getString("sex"));
        //     return emp;
        // }, 1);
        // System.out.println(empResult);

        // 写法二：
        String sql = """
                    select * 
                    from t_emp
                    where id = ?
                    """;

        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println(emp);
    }

    // 返回list集合
    @Test
    public void testSelectList(){
        String sql = "select * from t_emp";
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(list);
    }

    // 返回单个值
    @Test
    public void testSelectValue(){
        String sql = "select count(*) from t_emp";
        Integer value = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(value);
    }
}
