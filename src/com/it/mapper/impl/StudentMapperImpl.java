package com.it.mapper.impl;

import com.it.bean.Student;
import com.it.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentMapperImpl implements StudentMapper {

    @Override
    public List<Student> selectAll() {
        List<Student> list = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);
            list = sqlSession.selectList("StudentMapper.selectAll");

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
            stu = sqlSession.selectOne("StudentMapper.selectById", id);

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
            result = sqlSession.insert("StudentMapper.insert", stu);

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
            result = sqlSession.update("StudentMapper.update", stu);

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
            result = sqlSession.delete("StudentMapper.delete", id);

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
