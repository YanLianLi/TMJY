package MyBatisModel.dao;

import MyBatisModel.pojo.LoginTeacher;
import MyBatisModel.pojo.Teachers;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    //教师登陆
    List<LoginTeacher> login(Map<String,Object> map);
    //教师基本信息
    List<Teachers> TeacherInfo(String tid);

    //显示所有教师
    List<Teachers> showTeachers();

    //写入新的教师基本信息
    int addTeacher(Map<String,Object> map);

    //写入教师密码
    int addTeacherPWD(Map<String,Object> map);
    //删除教师
    int deleteTeacher(String tid);
}
