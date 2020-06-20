package frank.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 创建数据库连接的方式
 * 1.DirverManager:每次都是创建数据库物理连接,(connection.close())关闭物理连接
 * 2.DataSource:初始化就创建一定数量的连接,connection.close()关闭只是重置连接对象,归还连接池
 * DataSource创建连接的方式效率更好
 */

public class DBUtil {

    public static final String URL = "jdbc:mysql://localhost:3306/blogdemo";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";

    private static volatile DataSource DATA_SOURCE; //保证可见性 禁止指令重排序/建立内存屏障

    private DBUtil(){}

    /*
    获取数据库连接池:使用双重校验锁的单例模式创建数据库连接池
    自己使用 所以不开放
     */
    private static DataSource getDataSource() {
        if (DATA_SOURCE == null) {//并发执行效率高
            synchronized (DBUtil.class) {
                if (DATA_SOURCE == null) {//保证只创建一次,满足单例模式同一对象要求
                    DATA_SOURCE = new MysqlDataSource();//分配内存空间 对象初始化 等号赋值操作
                    ((MysqlDataSource) DATA_SOURCE).setURL(URL);
                    ((MysqlDataSource) DATA_SOURCE).setUser(USERNAME);
                    ((MysqlDataSource) DATA_SOURCE).setPassword(PASSWORD);
                }
            }
        }
        return DATA_SOURCE;
    }

    /*
    获取数据库连接:提供公共的方法给其他地方操作JDBC时获取数据库连接
     */
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败", e);
        }
    }

    /**
     * jdbc操作步骤
     * (1)创建数据库连接
     * (2)创建操作命令对象Statement
     * (3)执行sql
     * (4)如果是查询,处理结果集ResultSet
     * (5)释放资源
     */

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("关闭数据库连接", e);
        }
    }

    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }
}
