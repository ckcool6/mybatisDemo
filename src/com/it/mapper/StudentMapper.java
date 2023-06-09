package com.it.mapper;

import com.it.bean.Student;

import java.util.List;

public interface StudentMapper {
    public abstract List<Student> selectAll();

    //根据id查询
    public abstract Student selectById(Integer id);

    //新增数据
    public abstract Integer insert(Student stu);

    //修改数据
    public abstract Integer update(Student stu);

    //删除数据
    public abstract Integer delete(Integer id);

    public abstract List<Student> selectCondition(Student stu);
    public abstract List<Student> selectByIds(List<Integer> ids);

}
