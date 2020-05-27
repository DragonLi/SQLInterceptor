package com.example.demo.service;


import com.example.demo.entity.user;

import javax.annotation.Resource;

/**
 * @author wyh
 * @date 2019/12/9 0009
 */
@Resource
public interface UserService {
    String getUser();
    String insetUser(user user1);
}
