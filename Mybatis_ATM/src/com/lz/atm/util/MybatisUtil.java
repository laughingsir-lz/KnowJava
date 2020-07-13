package com.lz.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MybatisUtil
 * @Description:
 * @Author: zzz
 **/
public class MybatisUtil {
    private  static SqlSessionFactory factory;
    //加载配置文件 得到工厂对象
    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
           factory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 返回SqlSession
     * @return SqlSession
     */
    public static SqlSession openSession(){
        return factory.openSession();
    }
}
