package MyBatisModel;
import MyBatisModel.dao.CourseMapper;
import MyBatisModel.dao.StudentMapper;
import MyBatisModel.dao.TeacherMapper;
import MyBatisModel.pojo.*;
import MyBatisModel.utills.MybatisUntills;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    @Test
    public void test1(){
        SqlSession sql = MybatisUntills.getSqlSession();
        StudentMapper mapper = sql.getMapper(StudentMapper.class);
        String s = mapper.StudentState("2234110519");
        System.out.println(s);
        sql.close();
    }
    @Test
    public void test2(){
        SqlSession sql = MybatisUntills.getSqlSession();
        TeacherMapper mapper = sql.getMapper(TeacherMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("tid","2254110510");
        map.put("pwd","123456789");
        List<LoginTeacher> login = mapper.login(map);
        if(login.size()==0){
            System.out.println("登陆失败");
        }
        else {
            System.out.println("登陆成功！");
        }
        sql.close();
    }
}
