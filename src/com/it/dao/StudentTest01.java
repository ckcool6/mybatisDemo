package com.it.dao;

import com.it.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class StudentTest01 {
    @Test
    public void selectAll() throws IOException {
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        //2.获取sqlsession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //
        List<Student> list = sqlSession.selectList("StudentMapper.selectAll");

        //
        for (Student student : list) {
            System.out.println(student);
        }
        sqlSession.close();
        is.close();
    }
}
