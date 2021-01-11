package com.cas.controller;

import com.cas.mongodService.UserRepository;
import com.cas.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午6:31 2021/1/8
 * @version: V1.0
 * @review:
 */
@RequestMapping("/test")
@RestController
public class MongodbController {

    private static final Logger log = LoggerFactory.getLogger(MongodbController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/mongodb")
    @ResponseBody
    public String mongodb() {
        User user = new User();
        user.setUsername("xl");
        user.setPassword("123456");
        user.setHight("180");
        userRepository.saveUser(user);
        log.info("mongodb 查询数据: [{}]", userRepository.findUserByUserName("xl"));
        return "mongodb插入完毕";
    }

}
