package contaller.Student;

import MyBatisModel.dao.StudentMapper;
import MyBatisModel.pojo.LoginStudent;
import MyBatisModel.utills.MybatisUntills;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        ServletContext ctx = getServletContext();//移动端
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("接收到前端的数据");
        System.out.println("账号："+username+"密码: "+password);

        //Mybatis操作
        SqlSession sql = MybatisUntills.getSqlSession();
        StudentMapper mapper = sql.getMapper(StudentMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("sid",username);
        map.put("pwd",password);
        List<LoginStudent> st = mapper.StudentLogin(map);
        if(st.size()==0){
            resp.getWriter().write("账号或密码错误！");
            sql.close();
        }
        else {
            resp.getWriter().write("欢迎同学");
            HttpSession session = req.getSession();
            session.setAttribute("username",username);//存入session
            ctx.setAttribute("username",username);//移动端
            sql.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
