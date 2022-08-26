package com.tudublin.apms.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;

public class MybatisUtils {
    //利用static（静态）属于类不属于对象，且全局唯一
    private static SqlSessionFactory sqlSessionFactory = null;
    //利用静态块在初始化类时实例化sqlSessionFactory
    static{
        Reader reader = null;
        try {
            //读取mybatis-config.xml
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            //构建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            //初始化错误时，通常抛出异常ExceptionInInitializerError通知调用者
            System.err.println("MyBatisUtil Init Error");
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 执行SELECT查询SQL
     * @param func 要执行查询语句的代码块
     * @return 查询结果
     */
    public static Object executeQuery(Function<SqlSession, Object> func){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println("获取到的session对象" + sqlSession);
        try {
            Object obj = func.apply(sqlSession);
            return obj;
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 执行INSERT/UPDATE/DELETE写操作SQL
     * @param func 要执行的写操作代码块
     * @return 写操作后返回的结果
     */
    public static Object executeUpdate(Function<SqlSession,Object> func){
        //openSession传入false参数代表手动提交/回滚事物
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            Object obj = func.apply(sqlSession);
            sqlSession.commit();
            return obj;
        } catch (Exception e) {
            sqlSession.rollback();
            throw e;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public String toString() {
        return "MybatisUtils{}";
    }
}
