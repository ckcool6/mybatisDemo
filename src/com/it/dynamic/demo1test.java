package com.it.dynamic;

import com.it.bean.Student;
import com.it.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class demo1test {
    @Test
    public void selectCondition() throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student stu = new Student();
        stu.setId(2);
        stu.setName("李四");
        //stu.setAge(24);

        List<Student> list = mapper.selectCondition(stu);
        for (Student student : list) {
            System.out.println(student);
        }

        sqlSession.close();
        is.close();
    }

    @Test
    public void selectByIds() throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        List<Student> list = mapper.selectByIds(ids);
        for (Student student : list) {
            System.out.println(student);
        }

        sqlSession.close();
        is.close();
    }
}
