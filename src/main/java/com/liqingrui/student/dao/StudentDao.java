package com.liqingrui.student.dao;

import com.liqingrui.student.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {
    List<Student> selectList(@Param("student") Student student);

    @Delete("delete from t_student where id in (${ids})")
    int deleteByIds(@Param("ids") String ids);

    int update(@Param("student") Student student);

    int insert(@Param("student") Student student);

    @Select("select * from t_student where id=#{id}")
    Student selectById(@Param("id") Integer id);

}
