package com.it.service.impl;

import com.it.bean.Student;
import com.it.mapper.StudentMapper;
import com.it.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    //创建持久层对象


    @Override
    public List<Student> selectAll() {
        List<Student> list = null;
        SqlSession sqlSession = null;
        InputStream is = null;

        try {
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);

            //
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            list = mapper.selectAll();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;

    }

    @Override
    public Student selectById(Integer id) {
        Student stu = null;
        SqlSession sqlSession = null;
        InputStream is = null;

        try {
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);

            //
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            stu = mapper.selectById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return stu;
    }

    @Override
    public Integer insert(Student stu) {
        Integer result = null;
        SqlSession sqlSession = null;
        InputStream is = null;

        try {
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);

            //
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            result = mapper.insert(stu);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;

    }

    @Override
    public Integer update(Student stu) {
        Integer result = null;
        SqlSession sqlSession = null;
        InputStream is = null;

        try {
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);

            //
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            result = mapper.update(stu);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;

    }

    @Override
    public Integer delete(Integer id) {
        Integer result = null;
        SqlSession sqlSession = null;
        InputStream is = null;

        try {
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);

            //
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            result = mapper.delete(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;

    }
}
