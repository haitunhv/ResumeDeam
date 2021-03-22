import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;

/**
 * @Author: gss
 * @Date: 2021/3/21 22:14
 */
public class SkillTes  {

    @Test
    public void select() throws Exception{
        try(Reader reader = Resources.getResourceAsReader("mybatis-config.xml")){
            //创建一个工厂构建器
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //创建一个工厂
            SqlSessionFactory factory = builder.build(reader);

            //创建一个session
            SqlSession sqlSession = factory.openSession();
            //执行sql语句

            //关闭
            sqlSession.close();
        }
    }


}
