package com.liqingrui.test;

import com.github.pagehelper.PageInfo;
import com.liqingrui.student.model.Student;
import com.liqingrui.student.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test1 {
    @Autowired
    private StudentService studentService;
    @Test
    public void t1(){
        PageInfo<Student> pageInfo = studentService.getPageInfo(new Student(), 1, 3);
        System.err.println(pageInfo);
    }
}
