package com.baizhiedu.service;

import com.baizhiedu.dao.UserDAO;
import com.baizhiedu.entity.User;
import org.springframework.transaction.annotation.Transactional;

// 通过 @Transactional 注解配置切入点
// @Transactional(rollbackFor = {java.lang.Exception.class},noRollbackFor = {java.lang.RuntimeException.class})

// UserServiceImpl 是原始对象
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(User user) throws Exception {
        userDAO.save(user);
        throw new RuntimeException("测试"); // 这里抛出异常，事务会回滚，可以用来验证事务是否生效
        //throw new Exception("测试2");
    }

    @Override
    //@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void login(String name, String password) {

    }
}
