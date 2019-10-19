package com.liqingrui.student.controller;

import com.github.pagehelper.PageInfo;
import com.liqingrui.student.model.Area;
import com.liqingrui.student.model.Classes;
import com.liqingrui.student.model.Student;
import com.liqingrui.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生管理控制器
 */
@RestController
@RequestMapping("/student")
@CrossOrigin //解决跨域
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 列表页
     * @param student
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("getPageInfo")
    public PageInfo<Student> getPageInfo(Student student, @RequestParam(value = "pageNo",defaultValue = "1")Integer pageNo,@RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize){
//        System.err.println(student);
        return  studentService.getPageInfo(student,pageNo,pageSize);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @GetMapping("deleteByIds")
    public boolean deleteByIds(String ids){
        System.err.println(ids);
        return studentService.deleteByIds(ids);
    }

    /**
     * 保存/修改
     * @param student
     * @return
     */
    @PostMapping("save")
    public boolean save(@RequestBody Student student){
        return studentService.save(student);
    }
    @GetMapping("getById")
    public Object getById(Integer id){
        Map<String,Object> resultMap = new HashMap<>();
//        查询学生基本信息
        Student student = studentService.getById(id);
        resultMap.put("student",student);
//        查询对应的城市的数据
        List<Area> cityList = studentService.getAreaListByPid(student.getProvince_id());
        resultMap.put("cityList",cityList);
//        查询对应的地区的数据
        List<Area> areaList = studentService.getAreaListByPid(student.getCity_id());
        resultMap.put("areaList",areaList);
//        返回带有  城市 地区  学生的基本信息的map集合
        return resultMap;
    }
//    学生管理页面初始化数据接口
    @GetMapping("initData")
    public Object getClassesList(){
        Map<String,Object> resultMap = new HashMap<>();
//        班级列表
        List<Classes> list = studentService.getClassList();
        resultMap.put("classesList",list);
//        省列表
        List<Area> privinceList = studentService.getAreaListByPid(1);
        resultMap.put("privinceList",privinceList);
        return resultMap;
    }
//    根据pid 查询城市列表
    @GetMapping("getAreaListById")
    public List<Area> getAreaListById(Integer pid){
        return studentService.getAreaListByPid(pid);
    }
    @GetMapping("detail")
    public Object detail(Integer id){
        Map<String,Object> resultMap = new HashMap<>();
//        查询学生的基本信息
        Student student = studentService.getById(id);
        System.err.println(student+"------------");
//        设置省市区名称
        Area province = studentService.getAreaById(student.getProvince_id());
        Area city = studentService.getAreaById(student.getCity_id());
        Area area = studentService.getAreaById(student.getArea_id());
        student.setProvince_name(province.getName());
        student.setCity_name(city.getName());
        student.setArea_name(area.getName());
//        设置班级信息
        Classes classes = studentService.getClassesById(student.getClasses_id());
        student.setClasses_name(classes.getName());
        resultMap.put("student",student);
        return resultMap;
    }
}
