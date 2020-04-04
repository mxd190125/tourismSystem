package com.controller;

import com.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName TestController
 * @Version 1.0
 * @Author dell
 * @Date 2020/4/3 18:33
 * @Description TODO
 * Modification User:
 * Modification Date:
 */

@Controller
@RequestMapping("/tourism")
public class TestController {

    @Autowired
    private TestServiceImpl testService;

    /**
     * 测试连接数据库的控制器
     * @return
     */
    @RequestMapping("/getStr")
    @ResponseBody
    public String getStr(){
        String str="";
        str=testService.getStr();
        return str;
    }

}
