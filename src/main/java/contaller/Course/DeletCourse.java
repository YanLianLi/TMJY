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
import java.util.Map;

public class DeletCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        ServletContext c = getServletContext();
        HttpSession session = req.getSession();
        String sid = (String) session.getAttribute("username");
        if(sid==null){
            sid = (String) c.getAttribute("username");
        }

        //接收数据
        String cid = req.getParameter("cid");
        System.out.println("接收到的课程号为："+cid);

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        CourseMapper mapper = sql.getMapper(CourseMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("sid",sid);
        map.put("cid",cid);
        int i = mapper.DeletMyCourse(map);
        if(i==1){
            resp.getWriter().write("后端返回数据：删除成功");
            sql.commit();
        }
        else {
            resp.getWriter().write("后端返回数据：删除失败，请重试！");
        }
        sql.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
