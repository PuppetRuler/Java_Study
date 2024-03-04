package test;

import com.schedule.dao.impl.SysScheduleDaoImpl;
import com.schedule.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * ClassName:TestSysScheduleDao
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/13 17:28
 * @Version 1.0
 */
public class TestSysScheduleDao {
    private static SysScheduleDaoImpl scheduledao;

    @BeforeClass
    public static void initSchedule() {
        scheduledao = new SysScheduleDaoImpl();
    }

    @Test
    public void testAddSchedule(){
        int rows = scheduledao.addSchedule(new SysSchedule(null, 2, "JAVAWEB", 2));
        System.out.println(rows);
    }

    @Test
    public void testFindAll(){
        scheduledao.findAll().forEach(System.out::println);
    }
}
