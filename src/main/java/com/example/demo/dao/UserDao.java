package com.example.demo.dao;

import com.example.demo.entity.user;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wyh
 * @date 2019/12/9 0009
 */
@Mapper
public interface UserDao {
    int selectid();
    void insertname(user users);
}
