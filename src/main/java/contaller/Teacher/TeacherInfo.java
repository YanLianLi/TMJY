package contaller.Teacher;

import MyBatisModel.dao.TeacherMapper;
import MyBatisModel.pojo.Teachers;
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

public class TeacherInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        ServletContext c = getServletContext();
        String tid = (String) session.getAttribute("teacherid");
        if(tid==null){
            tid= (String) c.getAttribute("teacher");
        }

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        TeacherMapper mapper = sql.getMapper(TeacherMapper.class);
        List<Teachers> teachers = mapper.TeacherInfo(tid);
        sql.close();

        //打包
        Gson gson = new Gson();
        String json = gson.toJson(teachers);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
