package com.baizhiedu;

import com.baizhiedu.dao.UserDAO;
import com.baizhiedu.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 回顾 Mybatis 开发步骤:
 * 1. 实体
 * 2. 实体别名
 * 3. 表
 * 4. 创建DAO接⼝
 * 5. 实现Mapper⽂件
 * 6. 注册Mapper⽂件
 * 7. MybatisAPI调⽤
 */
public class TestMyBatis {

    @Test
    public void testMybatis() throws IOException {

        // 在 Mybatis 与 Spring 整合的过程中通过 SqlSessionFactoryBean 来封装如下两行代码
        // SqlSessionFactoryBean 依赖 mybatis-config.xml 中配置的信息创建 SqlSessionFactory
        // 数据源、类型别名、mapper文件位置
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 在 Mybatis 与 Spring 整合的过程中通过 MapperScannerConfigure 来封装如下两行代码
        // MapperScannerConfigure 依赖 sqlSessionFactory 和 XXXDAO.class 创建相应的动态代理对象
        SqlSession session = sqlSessionFactory.openSession();
        UserDAO userDAO = session.getMapper(UserDAO.class);

        User user = new User();
        user.setName("suns");
        user.setPassword("123456");
        userDAO.save(user);

        session.commit();
    }

}
