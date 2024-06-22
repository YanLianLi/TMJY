package contaller.Course;

import MyBatisModel.dao.CourseMapper;
import MyBatisModel.pojo.GetTeacherGrade;
import MyBatisModel.pojo.TeacherCourse;
import MyBatisModel.utills.MybatisUntills;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowTeacherCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        ServletContext c = this.getServletContext();
        String tid = (String) session.getAttribute("teacherid");
        if(tid==null){
            tid = (String) c.getAttribute("teacher");
        }

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        CourseMapper mapper = sql.getMapper(CourseMapper.class);
        List<TeacherCourse> tg = mapper.ShowTeacherCourse(tid);
        sql.close();


        //打包提交
        Gson gson = new Gson();
        String json = gson.toJson(tg);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
