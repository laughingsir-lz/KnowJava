package cn.lz.bank.util;

/**
 * @ClassName JDBCUtil
 * @Description: JDBC工具类
 * @Author: zzz
 **/
public class JDBCUtil {
    //加载注册驱动  
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
