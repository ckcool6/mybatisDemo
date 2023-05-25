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

    @Test
    public void selectById() throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student stu = sqlSession.selectOne("StudentMapper.selectById", 3);
        System.out.println(stu);
        sqlSession.close();
        is.close();
    }

    @Test
    public void insert() throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Student stu = new Student(4, "赵六", 26);
        int result = sqlSession.insert("StudentMapper.insert", stu);
        sqlSession.commit();

        System.out.println(result);

        sqlSession.close();
        is.close();
    }

    @Test
    public void update() throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Student stu = new Student(5, "周七", 21);
        int result = sqlSession.update("StudentMapper.update", stu);
        sqlSession.commit();

        System.out.println(result);

        sqlSession.close();
        is.close();
    }

    @Test
    public void delete() throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int result = sqlSession.delete("StudentMapper.delete", 5);
        sqlSession.commit();

        System.out.println(result);

        sqlSession.close();
        is.close();
    }
}
