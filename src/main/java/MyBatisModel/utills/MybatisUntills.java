package MyBatisModel.utills;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUntills {
    private static SqlSessionFactory sqlsessionfactory;

    static{
        String resource = "mybatis-config.xml";
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(is);
            sqlsessionfactory = sql;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSqlSession(){
        SqlSession sqlsession = sqlsessionfactory.openSession();
        return sqlsession;
    }
}
