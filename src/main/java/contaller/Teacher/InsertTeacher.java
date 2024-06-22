package contaller.Teacher;

import MyBatisModel.dao.TeacherMapper;
import MyBatisModel.pojo.Teachers;
import MyBatisModel.utills.MybatisUntills;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertTeacher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        //获取前端数据
        String tid = req.getParameter("tid");
        String tname = req.getParameter("tname");
        String tsex = req.getParameter("tsex");
        String tbirth = req.getParameter("tbirth");
        String taddress = req.getParameter("taddress");
        String tpwd = req.getParameter("tpwd");


        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        TeacherMapper mapper = sql.getMapper(TeacherMapper.class);
        List<Teachers> teachers = mapper.TeacherInfo(tid);
        if(teachers.size()>0){
            resp.getWriter().write("教职工编号已被占用");
        }
        else {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("tid",tid);
            map.put("tname",tname);
            map.put("tsex",tsex);
            map.put("tbirth",tbirth);
            map.put("taddress",taddress);
            int i = mapper.addTeacher(map);
            if(i==1){
                Map<String,Object> map1 = new HashMap<String,Object>();
                map1.put("tid",tid);
                map1.put("tpwd",tpwd);
                int i1 = mapper.addTeacherPWD(map1);
                if(i1==1){
                    resp.getWriter().write("信息更新成功");
                    sql.commit();
                }
                else {
                    resp.getWriter().write("密码更新错误");
                }
            }
            else {
                resp.getWriter().write("信息更新错误");
            }

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
