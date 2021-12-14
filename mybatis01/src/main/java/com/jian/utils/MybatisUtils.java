package com.jian.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**工具类 获取SqlSessionFactory对象
 * @autHor jzj
 * @create 2021 12 11 14:36
 */
public class MybatisUtils {
    public static SqlSessionFactory sqlSessionFactory;
    static {
        //官方给的固定获取SqlSessionFactory对象工具类步骤
        InputStream inputStream = null;
        try {
            String resource = "mybatis-config.xml";//读取xml配置文件
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
    // 你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句
    public  static SqlSession getSqlSession(){

        SqlSession sqlSession = sqlSessionFactory.openSession();//创建 SqlSession 实例 之后编写代码 创建数据库实体类 Dao接口和其实现类
        System.out.println(sqlSession);
        return sqlSession;


    }

}
