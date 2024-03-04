package com.atguigu.api.preparedStatement;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * ClassName:BankService
 * Description: bank表业务表
 *
 * @Author Sixty-three
 * @Create 2024/2/8 16:35
 * @Version 1.0
 */
public class BankService {

    /**
     * ergouzi给lvdandan转账
     */
    @Test
    public void start() throws Exception {
        transfer("ergouzi", "lvdandan", 500);
    }

    /**
     * 转钱的业务
     *
     * @param addAccount
     * @param subAccount
     * @param money
     */
    public void transfer(String subAccount, String addAccount, int money) throws Exception {

        JSch jsch = new JSch();

        // 连接SSH
        Session session = jsch.getSession("root", "192.168.171.150", 22);
        session.setPassword("123456");
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        // 开启SSH端口转发
        int forwardedPort = session.setPortForwardingL(0, "localhost", 3306);

        // 注册
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:"+forwardedPort+"/atguigu_jdbc?user=root&password=root");

        boolean flag = false;

        try {
            // 关闭事务自动提交
            connection.setAutoCommit(false);
            // 调用dao
            BankDAO bankDAO = new BankDAO();

            bankDAO.add(addAccount, money, connection);
            System.out.println("--------------------------------");
            bankDAO.sub(subAccount, money, connection);

            // 手动提交
            connection.commit();
            flag = true;
        } catch (Exception e) {
            connection.rollback();
            System.out.println("已回滚");
            throw e;
        } finally {
            connection.close();
            session.disconnect();
            String isOK = flag ? "转账成功" : "转账失败";
            System.out.println(isOK);
        }
    }
}
