package com.liqingrui.student.model;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private static final long serialVersionUID = -1480730593323838144L;
    private Integer id;
    private String name;
    private Integer sex;
    private Integer age;
    private Integer ageStart;
    private Integer ageEnd;
    private Date birthday;
    private String header_img;
    private Integer classes_id;
    private String classes_name;
    private Integer province_id;
    private Integer city_id;
    private Integer area_id;
    private String province_name;
    private String city_name;
    private String area_name;
    private String introduction;
    private Date create_time;

    public Student() {
    }

    public  String getFileName(){
        if(this.getHeader_img()==null){
            return null;
        }
        return this.getHeader_img().replace("http://127.0.0.1:81/","");
    }

    public Student(Integer id, String name, Integer sex, Integer age, Integer ageStart, Integer ageEnd, Date birthday, String header_img, Integer classes_id, String classes_name, Integer province_id, Integer city_id, Integer area_id, String province_name, String city_name, String area_name, String introduction, Date create_time) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.ageStart = ageStart;
        this.ageEnd = ageEnd;
        this.birthday = birthday;
        this.header_img = header_img;
        this.classes_id = classes_id;
        this.classes_name = classes_name;
        this.province_id = province_id;
        this.city_id = city_id;
        this.area_id = area_id;
        this.province_name = province_name;
        this.city_name = city_name;
        this.area_name = area_name;
        this.introduction = introduction;
        this.create_time = create_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHeader_img() {
        return header_img;
    }

    public void setHeader_img(String header_img) {
        this.header_img = header_img;
    }

    public Integer getClasses_id() {
        return classes_id;
    }

    public void setClasses_id(Integer classes_id) {
        this.classes_id = classes_id;
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(Integer ageStart) {
        this.ageStart = ageStart;
    }

    public Integer getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(Integer ageEnd) {
        this.ageEnd = ageEnd;
    }

    public String getClasses_name() {
        return classes_name;
    }

    public void setClasses_name(String classes_name) {
        this.classes_name = classes_name;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", ageStart=" + ageStart +
                ", ageEnd=" + ageEnd +
                ", birthday=" + birthday +
                ", header_img='" + header_img + '\'' +
                ", classes_id=" + classes_id +
                ", classes_name='" + classes_name + '\'' +
                ", province_id=" + province_id +
                ", city_id=" + city_id +
                ", area_id=" + area_id +
                ", province_name='" + province_name + '\'' +
                ", city_name='" + city_name + '\'' +
                ", area_name='" + area_name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
