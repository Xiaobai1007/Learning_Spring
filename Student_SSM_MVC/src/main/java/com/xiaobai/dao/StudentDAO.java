package com.xiaobai.dao;

import com.xiaobai.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentDAO {

    int insert(@Param("pojo") Student pojo);

    int insertSelective(@Param("pojo") Student pojo);

    int insertList(@Param("pojos") List<Student> pojo);

    int update(@Param("pojo") Student pojo);

    //不使用配置文件使用注解
    @Select("Select * from student where id = #{id}")
    Student getUserByIdForAnnotation(int id);
    @Select("Select * from student")
    List<Student> selectAll();

}
