package edu.stu.mybatis.test;

import edu.stu.mybatis.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class EmployeeTest {

    private static Logger log = Logger.getLogger(EmployeeTest.class);

    private static final String resource = "mybatis-config.xml";
    public static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLog() {
        //测试log4j日志配置是否正确
        log.debug("debug");
        log.error("error");
        System.out.println("Hello Log4J");
    }

    /*
     *以方法（假设叫方法a）的全类名作为字符串参数，调用SqlSession的相应方法，实现原来方法a的功能
     * */
    @Test
    public void getEmployeeByMethodFullName() {
        if (sqlSessionFactory != null) {
            SqlSession openSession = sqlSessionFactory.openSession();
            Employee e1 = openSession.selectOne("edu.stu.mybatis.dao.EmployeeMapper.getEmployeeById", 1);
            System.out.println(e1);

            openSession.close();
        }
    }
}
