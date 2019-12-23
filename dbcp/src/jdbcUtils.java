/**
 * @author ziv
 * @date 2019/12/19  16:19
 */
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 在java中，编写数据库连接池需实现java.sql.DataSource接口，每一种数据库连接池都是DataSource接口的实现
 * DBCP连接池就是java.sql.DataSource接口的一个具体实现
 */
public class jdbcUtils {

    private static DataSource ds = null;
    //在静态代码块中创建数据库连接池
    static{
        try{
            //加载dbcp.properties配置文件
            InputStream in =jdbcUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
            Properties prop = new Properties();
            prop.load(in);
            //创建数据源
            BasicDataSourceFactory factory = new BasicDataSourceFactory();
//            ds =factory.createDataSource(prop);
        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    //从数据源中获取数据库连接
    public static Connection getConnection()throws SQLException{
        //从数据源中获取数据库连接
        return ds.getConnection();
    }
    //释放连接
    public static void release(Connection conn){
        if(conn!=null){
            try{
                //将Connection连接对象还给数据库连接池
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}