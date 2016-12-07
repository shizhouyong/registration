package com.wl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shizhouyong on 2016/12/7.
 */
public class DbConn {

    public static Connection getconn() {
        final String url = "jdbc:mysql://121.40.201.195:3306/registration?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        final String user = "user";
        final String passwd = "abc123";
        Connection conn = null;

        // 连接数据库
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
