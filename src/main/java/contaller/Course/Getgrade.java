package contaller.Course;

import MyBatisModel.dao.CourseMapper;
import MyBatisModel.pojo.MyGrade;
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

public class Getgrade extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        ServletContext c = getServletContext();//移动端
        HttpSession session = req.getSession();
        String sid = (String) session.getAttribute("username");
        if(sid==null){
            sid= (String) c.getAttribute("username");
        }

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        CourseMapper mapper = sql.getMapper(CourseMapper.class);
        List<MyGrade> myGrades = mapper.ShowGrade(sid);
        sql.close();

        //打包发送
        Gson gson = new Gson();
        String json = gson.toJson(myGrades);
        resp.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
