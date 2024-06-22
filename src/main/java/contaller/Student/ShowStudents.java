package contaller.Student;

import MyBatisModel.dao.StudentMapper;
import MyBatisModel.pojo.Students;
import MyBatisModel.utills.MybatisUntills;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowStudents extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        System.out.println("查询学生后端搜到信息");

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        StudentMapper mapper = sql.getMapper(StudentMapper.class);
        List<Students> students = mapper.showStudent();
        sql.close();

        //打包
        Gson gson = new Gson();
        String json = gson.toJson(students);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
