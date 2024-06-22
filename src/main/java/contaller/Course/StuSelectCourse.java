package contaller.Course;

import MyBatisModel.dao.CourseMapper;
import MyBatisModel.utills.MybatisUntills;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StuSelectCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        ServletContext c = getServletContext();
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if(username == null){
            username = (String) c.getAttribute("username");
        }

        String cid = req.getParameter("cid");
        String cname = req.getParameter("cname");
        String ct = req.getParameter("cteacher");
        System.out.println("课程号"+cid);

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        CourseMapper mapper = sql.getMapper(CourseMapper.class);
        Map<String,Object> map1 = new HashMap<String, Object>();
        map1.put("cid",cid);
        map1.put("sid",username);
        String strings = mapper.showStudentCourse(map1);
        if(strings!=null){
            resp.getWriter().write("后端返回信息：该课程已存在！");
            sql.close();
        }
        else {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("cid",cid);
            map.put("sid",username);
            int i = mapper.addStudentCourse(map);
            sql.commit();
            if(i==1){
                resp.getWriter().write("后端返回信息：选课成功！");
                System.out.println("成！");
            }
            else {
                resp.getWriter().write("后端返回信息：选课失败！");
            }
            sql.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
