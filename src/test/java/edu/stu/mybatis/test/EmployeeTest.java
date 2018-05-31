package edu.stu.mybatis.test;

import edu.stu.mybatis.bean.Employee;
import edu.stu.mybatis.dao.EmployeeMapper;
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

    // 根据xml配置文件（全局配置文件）来创建SqlSessionFactory对象
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
     * 用映射文件的唯一标识，获得查询结果
     * */
    @Test
    public void getEmployeeByMethodFullName() {
        if (sqlSessionFactory != null) {
            // 使用SqlSessionFactory获取SqlSession对象，用该对象来执行增删改查操作。 一个SqlSession对象就代表和数据库的一次会话，使用完毕后需要关闭。
            SqlSession openSession = sqlSessionFactory.openSession();

            try {
                //selectOne的第一个参数必须为映射文件中的唯一标识
                Employee e1 = openSession.selectOne("edu.stu.mybatis.dao.EmployeeMapper.getEmployeeById", 2);
                System.out.println(e1);
            } finally {

                openSession.close();
            }

        }
    }

    /*
     * 用接口的实例（该实例实际上是一个代理对象，是Mybatis内部实例化而来）
     * */
    @Test
    public void getEmployeeByInterfaceInstance() {
        if (sqlSessionFactory != null) {
            SqlSession openSession = sqlSessionFactory.openSession();

            try {
                //获取接口的实现对象（实际上是由Mybatis自动创建的一个代理对象）
                EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
                Employee e2 = mapper.getEmployeeById(3);
                System.out.println(e2);
                System.out.println(mapper.getClass());//查看接口的实现对象的类型
                //System.out.println(Class.forName("com.sun.proxy.$Proxy9").newInstance().getClass());

            } finally {
                openSession.close();
            }

        }

    }


}
