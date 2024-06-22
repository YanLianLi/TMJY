package contaller.Course;

import MyBatisModel.dao.CourseMapper;
import MyBatisModel.pojo.GetTeacherGrade;
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

public class GetTeacherCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        ServletContext c = getServletContext();
        String tid = (String) session.getAttribute("teacherid");
        if(tid==null){
            tid = (String) c.getAttribute("teacher");
        }
        System.out.println("进入后端，账号为："+tid);

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        CourseMapper mapper = sql.getMapper(CourseMapper.class);
        List<GetTeacherGrade> list = mapper.TeacherCourse(tid);
        sql.close();

        //打包
        Gson gson = new Gson();
        String json = gson.toJson(list);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
