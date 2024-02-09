package com.atguigu.api.preparedStatement;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * ClassName: BankService
 * Description: bank表业务表
 *
 * @Author Sixty-three
 * @Create 2024/2/8 16:35
 * @Version 1.0
 */
public class ssh_test {

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
     * @param subAccount
     * @param addAccount
     * @param money
     */
    public void transfer(String subAccount, String addAccount, int money) throws Exception {

        JSch jsch = new JSch();

        // SSH连接信息
        String sshHost = "192.168.171.150";
        String sshUsername = "root";
        String sshPassword = "123456";
        int sshPort = 22; // SSH默认端口

        // 数据库连接信息
        String dbHost = "localhost";
        int dbPort = 3306; // MySQL默认端口
        String dbName = "atguigu_jdbc";
        String dbUsername = "root";
        String dbPassword = "root";

        // 连接SSH
        Session session = jsch.getSession(sshUsername, sshHost, sshPort);
        session.setPassword(sshPassword);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        // 开启SSH端口转发
        int forwardedPort = session.setPortForwardingL(0, dbHost, dbPort);

        // 数据库连接URL
        String dbUrl = "jdbc:mysql://localhost:" + forwardedPort + "/" + dbName;

        boolean flag = false;
        Connection connection = null;
        try {
            // 注册数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 获取数据库连接
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
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
            if (connection != null) {
                connection.rollback();
            }
            System.out.println("已回滚");
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            session.disconnect();
            String isOK = flag ? "转账成功" : "转账失败";
            System.out.println(isOK);
        }
    }
}
