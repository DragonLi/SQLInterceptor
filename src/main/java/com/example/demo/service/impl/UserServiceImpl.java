package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.user;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wyh
 * @date 2019/12/9 0009
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public String getUser() {
        int res = userDao.selectid();
        if (res == 1) {
            return "success";
        } else {
            return "false";
        }
    }

    @Override
    public String insetUser(user user1) {
        userDao.insertname(user1);
        return "创建成功";
    }

}
