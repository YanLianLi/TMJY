package contaller.Course;

import MyBatisModel.dao.CourseMapper;
import MyBatisModel.utills.MybatisUntills;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TeacherInsertCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String sid = req.getParameter("sid");
        String cid = req.getParameter("cid");
        String grade = req.getParameter("grade");
        System.out.println("教师提交成绩"+sid+cid+grade);

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        CourseMapper mapper = sql.getMapper(CourseMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("sid",sid);
        map.put("cid",cid);
        map.put("grade",grade);
        int i = mapper.TeacherInsertGrade(map);
        sql.commit();
        if(i==1){
            resp.getWriter().write("上传成功");
        }
        else {
            resp.getWriter().write("上传失败");
        }
        sql.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
