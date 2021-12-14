package com.jian.dao;


import com.jian.pojo.Admin;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**此步骤可被配置文件替换    AdminMapper.xml
 * @autHor jzj
 * @create 2021 12 11 14:56
 */
public class AdminDaoImpl {
    public static void main(String[] args) {
        //获取sqlSession工具类对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 方式一 ：执行sql
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);//获取接口对象执行里面的方法
        List<Admin> adminList = adminMapper.getAdminList();
        for (Admin admin : adminList) {
            System.out.println(admin);

        }
        //关闭SqlSession
        sqlSession.close();
    }
}
