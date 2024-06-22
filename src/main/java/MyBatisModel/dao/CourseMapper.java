package MyBatisModel.dao;

import MyBatisModel.pojo.*;
import contaller.Course.GetMyCourse;

import java.util.List;
import java.util.Map;

public interface CourseMapper {
    List<SelectCourse> getAllCourse();
    //写入学生选课表
    int addStudentCourse(Map<String,Object> map);
    //遍历学生选课表
    String showStudentCourse(Map<String,Object> map);
    //学生查看课表
    List<MyCourse> ShowMyCourse(String cid);
    //退课删除
    int DeletMyCourse(Map<String,Object> map);
    //成绩查询
    List<MyGrade> ShowGrade(String sid);
    //老师添加课程
    int InertCourse(Map<String,Object> map);
    //查看学生所有成绩
    List<GetTeacherGrade> TeacherCourse(String tid);
    //教师提交成绩
    int TeacherInsertGrade(Map<String,Object> map);

    //教师查看自己的安排
    List<TeacherCourse> ShowTeacherCourse(String cid);
}
