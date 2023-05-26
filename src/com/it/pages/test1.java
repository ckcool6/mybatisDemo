package com.it.pages;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.bean.Student;
import com.it.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test1 {
    @Test
    public void selectPaging() throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //
        PageHelper.startPage(1,1);
        PageHelper.startPage(2,1);
        PageHelper.startPage(3,1);

        List<Student> list = mapper.selectAll();


        for (Student student : list) {
            System.out.println(student);
        }

        PageInfo<Student> info = new PageInfo<>(list);
        System.out.println(info.getTotal());
        System.out.println(info.getPages());
        System.out.println(info.getPageNum());
        System.out.println(info.getPageSize());
        System.out.println(info.getPrePage());
        System.out.println(info.getNextPage());

        sqlSession.close();
        is.close();
    }
}
