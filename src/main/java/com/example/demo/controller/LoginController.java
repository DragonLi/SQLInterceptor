package com.example.demo.controller;

import com.example.demo.entity.user;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyh
 * @date 2019/12/9 0009
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/loginhtml")
    public String loginhtml() {
        return userService.getUser();
    }

    @GetMapping("/insert")
    public String insertUserName(user user1) {
        return userService.insetUser(user1);
    }
}
