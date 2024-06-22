package contaller.Teacher;

import MyBatisModel.dao.TeacherMapper;
import MyBatisModel.pojo.Teachers;
import MyBatisModel.utills.MybatisUntills;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowTeachers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        TeacherMapper mapper = sql.getMapper(TeacherMapper.class);
        List<Teachers> teachers = mapper.showTeachers();
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
