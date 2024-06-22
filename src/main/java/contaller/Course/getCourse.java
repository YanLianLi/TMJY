package contaller.Course;

import MyBatisModel.dao.CourseMapper;
import MyBatisModel.pojo.SelectCourse;
import MyBatisModel.utills.MybatisUntills;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class getCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        CourseMapper mapper = sql.getMapper(CourseMapper.class);
        List<SelectCourse> allCourse = mapper.getAllCourse();//执行并返回数据
        for (SelectCourse selectCourse : allCourse) {
            System.out.println(selectCourse.getCid()+selectCourse.getCname()+selectCourse.getTname());
        }
        sql.close();

        //打包
        Gson gson = new Gson();
        String JsonData = gson.toJson(allCourse);
        //发送
        resp.getWriter().write(JsonData);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
