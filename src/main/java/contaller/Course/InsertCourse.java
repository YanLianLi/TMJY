package contaller.Course;

import MyBatisModel.dao.CourseMapper;
import MyBatisModel.pojo.Course;
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
import java.util.Map;

public class InsertCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        ServletContext c = getServletContext();
        HttpSession session = req.getSession();
        String teacherid = (String) session.getAttribute("teacherid");
        if(teacherid==null){
            teacherid = (String) c.getAttribute("teacher");
        }
        String cid = req.getParameter("cid");
        String cname = req.getParameter("cname");
        System.out.println(cname);
        String ctime = req.getParameter("ctime");

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        CourseMapper mapper = sql.getMapper(CourseMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("cid",cid);
        map.put("cname",cname);
        map.put("tid",teacherid);
        map.put("ctime",ctime);
        int i = mapper.InertCourse(map);
        if(i==1){
            resp.getWriter().write("添加成功！");
            sql.commit();
        }
        else {
            resp.getWriter().write("添加失败！课程号冲突！");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
