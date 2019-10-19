package com.liqingrui.student.dao;

import com.liqingrui.student.model.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Mapper
@Repository
public interface AreaDao {
    @Select("select * from t_area where pid=#{pid}")
    List<Area> selectListByPid(@Param("pid") Integer pid);

    List<Area> selectListByIds(@Param("areaIdList") Set<Integer> areaIdList);

    @Select("select * from t_area where id=#{id}")
    Area selectById(@Param("id") Integer id);
}
