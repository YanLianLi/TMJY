package contaller.Student;

import MyBatisModel.dao.StudentMapper;
import MyBatisModel.pojo.Students;
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

public class InsertStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String sid = req.getParameter("sid");
        String sname = req.getParameter("sname");
        String sbirth = req.getParameter("sbirth");
        String saddress = req.getParameter("saddress");
        String spwd = req.getParameter("spwd");
        String ssex = req.getParameter("ssex");

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        StudentMapper mapper = sql.getMapper(StudentMapper.class);
        List<Students> student = mapper.getStudent(sid);
        if(student.size()!=0){
            resp.getWriter().write("该学号已存在");
        }
        else {
            Map<String,Object> map1 = new HashMap<String, Object>();
            map1.put("sid",sid);
            map1.put("sname",sname);
            map1.put("sbirth",sbirth);
            map1.put("saddress",saddress);
            map1.put("ssex",ssex);
            int i = mapper.InsertStudent(map1);
            if(i==1){
                Map<String,Object> map2 = new HashMap<String, Object>();
                map2.put("sid",sid);
                map2.put("pwd",spwd);
                int i1 = mapper.InsertPWD(map2);
                if(i1==1){
                    sql.commit();
                    resp.getWriter().write("更新成功！");
                }
                else {
                    resp.getWriter().write("密码更新失败!");
                }
            }
            else {
                resp.getWriter().write("基本信息更新失败");
            }
        }
        sql.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
