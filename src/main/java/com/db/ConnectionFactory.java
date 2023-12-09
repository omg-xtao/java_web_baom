package com.db;

import com.mybatisflex.core.MybatisFlexBootstrap;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author xtaod
 */
public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://114.132.198.201:3306/eers?useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "ved3ype-VHN9udv_gtz";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    public static <T> T getMapper(Class<T> clazz) {
        MybatisFlexBootstrap bootstrap = MybatisFlexBootstrap.getInstance()
                .setDataSource(getDataSource())
                .addMapper(clazz)
                .start();
        return bootstrap.getMapper(clazz);
    }
}
