package com.it.service.impl;

import com.it.bean.Student;
import com.it.mapper.StudentMapper;
import com.it.mapper.impl.StudentMapperImpl;
import com.it.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    //创建持久层对象
    private StudentMapper mapper = new StudentMapperImpl();

    @Override
    public List<Student> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Student selectById(Integer id) {
        return mapper.selectById(id);
    }

    @Override
    public Integer insert(Student stu) {
        return mapper.insert(stu);
    }

    @Override
    public Integer update(Student stu) {
        return mapper.update(stu);
    }

    @Override
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }
}
