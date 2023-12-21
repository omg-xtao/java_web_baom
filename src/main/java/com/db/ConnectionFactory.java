package com.db;

import com.mybatisflex.core.MybatisFlexBootstrap;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ibatis.session.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author xtaod
 */
public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://114.132.198.201:3306/eers?useSSL=false&serverTimezone=Asia/Shanghai";
    public static final String USER = "root";
    public static final String PASSWORD = "ved3ype-VHN9udv_gtz";
    public static MybatisFlexBootstrap bootstrap;

    public static HashMap<String, Object> mappers = new HashMap<>();

    public static DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    public static void start() {
        if (bootstrap != null) {
            return;
        }
        bootstrap = MybatisFlexBootstrap.getInstance()
                .setDataSource(getDataSource())
                .start();
    }

    public static <T> void addMapper(Class<T> clazz) {
        if (bootstrap == null) {
            start();
        }
        Configuration var10001 = bootstrap.getConfiguration();
        if (var10001.hasMapper(clazz)) {
            return;
        }
        bootstrap.addMapper(clazz);
        var10001.addMapper(clazz);
    }

    public static <T> T getMapper(Class<T> clazz) {
        Object mapper = mappers.get(clazz.toString());
        if (mapper == null) {
            synchronized (ConnectionFactory.class) {
                mapper = mappers.get(clazz.toString());
                if (mapper == null) {
                    addMapper(clazz);
                    mappers.put(clazz.toString(), mapper = bootstrap.getMapper(clazz));
                }
            }
        }
        return clazz.cast(mapper);
    }
}
