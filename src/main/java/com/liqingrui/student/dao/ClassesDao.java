package com.liqingrui.student.dao;

import com.liqingrui.student.model.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ClassesDao {
    @Select("select * from t_classes")
    List<Classes> selectList();
    @Select("select * from t_classes where id=#{id}")
    Classes getClassesById(@Param("id") Integer id);
}
