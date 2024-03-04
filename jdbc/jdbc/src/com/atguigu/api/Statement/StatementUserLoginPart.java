package com.atguigu.api.Statement;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * ClassName:StatementUserLoginPart
 * Description: 模拟用户登录
 * TODO:
 *  1.明确jdbc的使用流程和详细讲解内部设计api方法
 *  2.发现问题，引出preparedStatement
 * TODO:
 *  输入账号和密码
 *  进行数据库信息查询(t_User)
 *  反馈登录成功还是登录失败
 * TODO:
 *  1.键盘输入事件，收集账号和密码信息
 *  2.注册驱动
 *  3.获取连接
 *  4.创建statement
 *  5.发送查询SQL语句，并获取返回结果
 *  6.结果判断，显示登录成功还是失败
 *  7.关闭资源
 *
 * @Author Sixty-three
 * @Create 2024/2/7 17:11
 * @Version 1.0
 */
public class StatementUserLoginPart {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1. 获取输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("account:");
        String account = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();

        //2. 注册驱动
        /*
            方案1：
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver())
                注意： 8+ com.mysql.cj.jdbc.Driver
                      5+ com.mysql.jdbc.Driver
            问题：注册两次驱动
                1.DriverManager.registerDriver()方法本身会注册一次！
                2.Driver.static{DriverManager.registerDriver()}静态代码块，也会注册一次！
            解决：只想注册一次驱动
                只触发静态代码块即可
            触发静态代码块：
                类加载机制：类加载的时刻，会触发静态代码块！
                        加载
                        连接
                        初始化

        * */
        // DriverManager.registerDriver(new Driver());

        // 注册驱动 固定的写法！ mysql - mysql Driver || 切换了数据库 oracle driver | 还需要修改代码
        // new Driver();

        // 反射 字符串的Driver全限定符 可以引导外部的配置文件 -> xx.properties -> oracle -> 配置文件修改
        Class.forName("com.mysql.cj.jdbc.Driver");

        /*
        * getConnection(1,2,3)方法，是一个重载方法！
        * 允许开发者，用不同的形式传入数据库连接的核心参数！
        *
        * 核心属性：
            1. 数据库软件所在的主机的ip地址：localhost/127.0.0.1
            2. 数据库软件所在的主机的瑞口号：3306
            3. 连接的具体库：atguigu_jdbc
            4. 连接的账号：root
            5. 连接的密码：root
            6. 可选的信息 没有

        *
        * 三个参数：
            String url          数据库软件所在的信息，连接的具体库，以及其他可选信息！
                                语法：jdbc:数据库管理软件名称[mysql,oracle]://ip地址|主机名:port端口号/数据库名?key=valve
                                    &key=valve可选信息！
                                具体：jdbc:mysgl://127.0.0.1:3306/atguigu_jdbc
                                     jdbc:mysql://localhost:3306/atguigu_jdbc
                                本机的省略写法：如果你的数据库软件安装到本机，可以进行一些省略
                                    jdbc:mysql://127.0.0.1:3306/atguigu_jdbc = jdbc:mysql:///atguigu_jdbc
                                    省略了[本机地址]和[3306默认端口号]！
                                    强调：必须是本机，并且端口号使3306方可省略使用///
            String user         数据库的账号root
            String password     数据库的密码root
           二个参数：
            String url:         和三个参数的url一样
            Properties info:    存储帐号和密码
                                Properties类似于 Map 只不过 key = valve 都是字符串形式的！
                                key 账户信息
                                key 密码信息
           一个参数：
            String url:         数据库ip,端口号，具体的数据库可选信息（账号密码）
                                jdbc:数据库软件名：//ip:port/数据库?key=valve&key=valve&key=valve
                                jdbc:mysql://localhost:3306/atguigu_jdbc?user=root&password=root
                                携带固定的参数名user password传递账号和密码信息！[乌龟的屁股，规定！]
           URL的路径属性可选信息：
                                8.0.25以后，自动识别时区 serverTimezone=Asia/Shanghai 不用添加
                                8版本以后， 默认使用utf-8格式, useUnicode=true&characterEncoding=utf8&useSSL=true 不用添加
                                serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=true

        * */
        // DriverManager.getConnection("jdbc:mysql:///atguigu_jdbc", "root", "root");

        // Properties properties = new Properties();
        // properties.put("user", "root");
        // properties.put("password", "root");
        // DriverManager.getConnection("jdbc:mysql:///atguigu_jdb", properties);

        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu_jdbc?user=root&password=root");

        // 发送SQL语句(1.编写SQL语句2.发送SQL语句)
        String sql = "select * from t_user where account = '"+account+"' and password = '"+password+"' ;";

        /*
        * SQL分类：DDL(容器创建，修改，删除) DML(插入，修改，删除) DQL(查询) DCL(权限控制) TPL(事务控制语言)
        *
        * 参数： sql 非DQL
        * 返回： int
        *           情况1: DML 返回影响的行数，例如： 修改了三条数据 return 3;
        *           情况2: 非DML return 0;
        * int row = executeUpdate(sql);
        *
        * 参数: sql DQL
        * 返回: resultSet 结果封装对象
        * ResultSet resultSet = executeQuery(sql);
        * */
        Statement statement = connection.createStatement();

        // int row = statement.executeUpdate(sql);
        ResultSet resultSet = statement.executeQuery(sql);

        /*
        想要进行数据解析，我们需要进行两件事情：1.移动游标指定获取数据行2.获取指定数据行的列数据即可
            1. 游标移动问题
                resultSet内部包含一个游标，指定当前行数据！
                默认游标指定的是第一行数据之前！
                我们可以调用next方法向后移动一行游标！
                如果我们有很多行数据，我们可以使用while(next){获取每一行的数据}

                boolean next()  true:有更多行数据，并且向下移动一行
                                false:没有更多行数据，不一定！
            TODO:移动光标的方法有很多，只需要记neXt即可，配合while循环获取全部数据

            2. 获取列的数据问题（获取光标指定的行的列的数据）

                resultSet.get(String columnLabel int columnIndex);
                    columnLabel: 列名如果有别名写别名       select (id,account,password,nickname)
                                                         select id as aid,account as ac from
                    columnIndex: 列的下角标获取    从左向右    从1开始
        * */

        // while (resultSet.next()) {
        //     // 指定当前行
        //     int id = resultSet.getInt(1);
        //     String account1 = resultSet.getString("account");
        //     String password1 = resultSet.getString(3);
        //     String nickname = resultSet.getString("nickname");
        //     System.out.println("nickname:" + nickname);
        // }

        // 移动一次光标，就登录成功
        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        // 关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}

// - 存在问题
//         1. SQL语句需要字符串拼接,比较麻烦（示例代码在：执行SQL语句 [动态SQL语句,需要字符串拼接]）
//         2. 只能拼接字符串类型,其他的数据库类型无法处理
//         3. **可能发生注入攻击**
//
//         > 动态值充当了SQL语句结构,影响了原有的查询结果!
