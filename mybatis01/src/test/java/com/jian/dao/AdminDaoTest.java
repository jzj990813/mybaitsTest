package com.jian.dao;

import com.jian.pojo.Admin;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


/**
 * @autHor jzj
 * @create 2021 12 11 15:14
 */
public class AdminDaoTest {
  static  Logger logger = Logger.getLogger(AdminDaoTest.class);
    @Test
    public void Test1(){
        //获取sqlSession工具类对象
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            // 方式一 ：执行sql
            AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);//获取接口对象执行里面的方法
            List<Admin> adminList = adminMapper.getAdminList();
            for (Admin admin : adminList) {
                System.out.println(admin);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }
    @Test
    public  void Test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(); //固定步骤
        try {
            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
            Admin admin= mapper.getAdminByID(1);
            System.out.println(admin);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();//固定关闭步骤
        }
    }
    //增删改必须需要提交事务
    @Test
    public  void Test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int num = mapper.addAdmin(new Admin(4, "简中豪", "123456"));
        if (num>0){
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    //修改
    @Test
    public void Test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        mapper.updateAdmin(new Admin(4,"简中友","456789"));
        sqlSession.commit();
        sqlSession.close();
    }
    //删除
    @Test
    public  void Test5(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        mapper.deleteAdmin(4);
        sqlSession.commit();
        sqlSession.close();
    }
    //模糊查询
    @Test
    public void Test6(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Admin> arrAdmin = mapper.getAdminLike("杰");
        for (Admin admin : arrAdmin) {
            System.out.println(admin);
        }
        sqlSession.close();
    }

  //log4j测试
    @Test
    public void Test7() {
        logger.info("info:进入log4j");
        logger.debug("debug:进入debug调试");
        logger.error("error:进入error调试");
    }
  //分页查询
    @Test
    public void Test8(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        //map参数的使用
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<Admin> adminLimit = mapper.getAdminLimit(map);
        for (Admin admin : adminLimit) {
            System.out.println(admin);
            
        }
        sqlSession.close();
    }
    //注解查询
   /*
    public void Test9(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Admin> adminList = mapper.getAdmin();
        for (Admin admin : adminList) {
            System.out.println(admin);
        }
        sqlSession.close();
    }
  */
}
