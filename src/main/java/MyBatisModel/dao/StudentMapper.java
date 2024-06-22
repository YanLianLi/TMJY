package MyBatisModel.dao;

import MyBatisModel.pojo.LoginStudent;
import MyBatisModel.pojo.Students;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    List<Students> getStudent(String sid);
    List<LoginStudent> StudentLogin(Map<String,Object> map);
    String StudentState(String sid);
    String getAdmin(Map<String,Object> map);

    //查询所有学生
    List<Students> showStudent();

    //添加学生
    int InsertStudent(Map<String,Object> map);

    //添加密码
    int InsertPWD(Map<String,Object> map);
}
