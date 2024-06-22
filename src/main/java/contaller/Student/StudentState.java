package contaller.Student;

import MyBatisModel.dao.StudentMapper;
import MyBatisModel.utills.MybatisUntills;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class StudentState extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();//网页端
        ServletContext context = getServletContext();//移动端
        String username = (String) session.getAttribute("username");
        if(username==null){
            username = (String) context.getAttribute("username");//移动端
        }
        System.out.println("数据同步："+username);

        //Mybatis部分
        SqlSession sql = MybatisUntills.getSqlSession();
        StudentMapper mapper = sql.getMapper(StudentMapper.class);
        String s = mapper.StudentState(username);
        System.out.println(s);
        sql.close();
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
