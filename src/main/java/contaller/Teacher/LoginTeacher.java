package contaller.Teacher;

import MyBatisModel.dao.TeacherMapper;
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

public class LoginTeacher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String tid = req.getParameter("tid");
        String pwd = req.getParameter("pwd");
        System.out.println(tid+pwd);

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        TeacherMapper mapper = sql.getMapper(TeacherMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("tid",tid);
        map.put("pwd",pwd);
        List<MyBatisModel.pojo.LoginTeacher> login = mapper.login(map);
        if(login.size()==0){
            resp.getWriter().write("账号密码错误");
        }
        else {
            resp.getWriter().write("登陆成功！");
            HttpSession session = req.getSession();
            ServletContext c = getServletContext();
            session.setAttribute("teacherid",tid);
            c.setAttribute("teacher",tid);
        }
        sql.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
