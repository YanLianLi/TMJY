package contaller.Teacher;

import MyBatisModel.dao.TeacherMapper;
import MyBatisModel.pojo.Teachers;
import MyBatisModel.utills.MybatisUntills;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteTeacher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String tid = req.getParameter("tid");

        System.out.println(tid);

        SqlSession sql = MybatisUntills.getSqlSession();
        TeacherMapper mapper = sql.getMapper(TeacherMapper.class);
        List<Teachers> teachers = mapper.TeacherInfo(tid);
        if(teachers.size()==0){
            resp.getWriter().write("该教师不存在！");
        }
        else {
            int i = mapper.deleteTeacher(tid);
            if(i==1){
                resp.getWriter().write("删除成功，此操作无法撤销！");
                sql.commit();
            }
            else {
                resp.getWriter().write("删除失败！");
            }
            sql.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
