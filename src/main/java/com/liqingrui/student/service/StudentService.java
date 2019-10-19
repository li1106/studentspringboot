package com.liqingrui.student.service;

import com.github.pagehelper.PageInfo;
import com.liqingrui.student.model.Area;
import com.liqingrui.student.model.Classes;
import com.liqingrui.student.model.Student;

import java.util.List;

/**
 * 
 */
public interface StudentService {
    PageInfo<Student> getPageInfo(Student student, Integer pageNo, Integer pageSize);

    boolean deleteByIds(String ids);

    boolean save(Student student);

    Student getById(Integer id);

    List<Area> getAreaListByPid(Integer province_id);

    List<Classes> getClassList();

    Area getAreaById(Integer province_id);

    Classes getClassesById(Integer classes_id);
}
