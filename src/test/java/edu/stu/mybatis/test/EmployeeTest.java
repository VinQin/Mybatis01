package edu.stu.mybatis.test;

import org.apache.ibatis.io.Resources;
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
    private void testLog() {
        //测试log4j日志配置是否正确
        log.debug("debug");
        log.error("error");
    }

    /*
     *以方法（假设叫方法a）的全类名作为字符串参数，调用SqlSession的相应方法，实现原来方法a的功能
     * */


}
