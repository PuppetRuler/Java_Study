package test;

import com.schedule.dao.BaseDao;
import com.schedule.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * ClassName:TestBaseDao
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/13 16:51
 * @Version 1.0
 */
public class TestBaseDao {
    private static BaseDao baseDao;

    @BeforeClass
    public static void initBaseDao() {
        baseDao = new BaseDao();
    }

    @Test
    public void testBaseQueryObject() {
        // 查询用户数量

        String sql = "select count(1) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);
    }
    
    @Test
    public void testBaseQuery(){
        String sql = "select uid,username,user_pwd userPwd from sys_user;";
        List<Object> objects = baseDao.baseQuery(SysSchedule.class,sql);
        objects.forEach(System.out::println);
    }

    @Test
    public void testBaseUpdate(){
        String sql = "insert into sys_schedule values(DEFAULT,1,'学习JAVA',1)";
        int rows = baseDao.baseUpdate(sql);
        System.out.println(rows);
    }
}
