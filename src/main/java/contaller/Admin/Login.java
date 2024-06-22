package contaller.Admin;

import MyBatisModel.dao.StudentMapper;
import MyBatisModel.utills.MybatisUntills;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        //Mybatis
        SqlSession sql = MybatisUntills.getSqlSession();
        StudentMapper mapper = sql.getMapper(StudentMapper.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",username);
        map.put("pwd",pwd);
        String admin = mapper.getAdmin(map);
        if(admin!=null){
            resp.getWriter().write("登陆成功");
        }
        else {
            resp.getWriter().write("登陆失败");
        }
        sql.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
