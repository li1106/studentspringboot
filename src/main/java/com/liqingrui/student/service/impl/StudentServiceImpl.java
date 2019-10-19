package com.liqingrui.student.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liqingrui.student.dao.AreaDao;
import com.liqingrui.student.dao.ClassesDao;
import com.liqingrui.student.dao.StudentDao;
import com.liqingrui.student.model.Area;
import com.liqingrui.student.model.Classes;
import com.liqingrui.student.model.Student;
import com.liqingrui.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private ClassesDao classesDao;
    @Autowired
    private AreaDao areaDao;
    @Autowired
    private StudentDao studentDao;

    @Override
    public PageInfo<Student> getPageInfo(Student student, Integer pageNo, Integer pageSize) {
//        设置分页
        PageHelper.startPage(pageNo, pageSize);
//        查询学生列表数据
        List<Student> studentList = studentDao.selectList(student);
//        查询所有的班级
        List<Classes> classesList = classesDao.selectList();
//        设置班级名称
         /*for(int i=0;i<studentList.size();i++){
            Student stu = studentList.get(i);
            Classes classes = classesDao.selectById(stu.getClasses_id());
            stu.setClasses_name(classes.getName());
        }*/
        /*List<Area> areas = areaDao.selectAll();*/
//         把每个学生的省的id存入到set集合当中     .collect(Collectors.toSet());优雅的将对象转换成另一种对象
        Set<Integer> areaIdList = studentList.stream().map(c -> c.getProvince_id()).collect(Collectors.toSet());
//        把每个学生的市的id存入到set集合当中
        areaIdList.addAll(studentList.stream().map(c->c.getCity_id()).collect(Collectors.toSet()));
//        把每个学生的区的id存入到set集合当中
        areaIdList.addAll(studentList.stream().map(c->c.getArea_id()).collect(Collectors.toSet()));
        List<Area> areas = areaDao.selectListByIds(areaIdList);
        studentList.forEach(stu->{
//        遍历学生的信息以及所有班级的信息  学生对应班级的id和班级的信息达成一致 并赋上班级的值
            classesList.forEach(cls->{
                if(stu.getClasses_id().intValue()==cls.getId().intValue()){
                    stu.setClasses_name(cls.getName());
                }
            });
//            便利学生的信息以及所有省市县的信息  学生对应地区的id和地区的信息达成一致 并赋上地区的值
            areas.forEach(area -> {
                if(stu.getProvince_id().intValue()==area.getId().intValue()){
                    stu.setProvince_name(area.getName());
                }
                if(stu.getCity_id().intValue()==area.getId().intValue()){
                    stu.setCity_name(area.getName());
                }
                if(stu.getArea_id().intValue()==area.getId().intValue()){
                    stu.setArea_name(area.getName());
                }
            });
        });
        return new PageInfo<>(studentList);
    }

    @Override
    public boolean deleteByIds(String ids) {
        return studentDao.deleteByIds(ids) > 0;
    }

    @Override
    public boolean save(Student student) {
        if (student.getId() != null) {
            return studentDao.update(student) > 0;
        }
        student.setCreate_time(new Date());
        return studentDao.insert(student) > 0;
    }

    @Override
    public Student getById(Integer id) {
        return studentDao.selectById(id);
    }

    @Override
    public List<Area> getAreaListByPid(Integer province_id) {
        return areaDao.selectListByPid(province_id);
    }

    @Override
    public List<Classes> getClassList() {
        return classesDao.selectList();
    }

    @Override
    public Area getAreaById(Integer province_id) {
        return areaDao.selectById(province_id);
    }

    @Override
    public Classes getClassesById(Integer classes_id) {
        return classesDao.getClassesById(classes_id);
    }

}
