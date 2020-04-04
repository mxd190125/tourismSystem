package com.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.impl.TestQueueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName TestQueueController
 * @Version 1.0
 * @Author dell
 * @Date 2020/4/3 20:26
 * @Description TODO
 * Modification User:
 * Modification Date:
 */

@RequestMapping("/queue")
@RestController
public class TestQueueController {

    private ObjectMapper objectMapper=new ObjectMapper();

    @Autowired
    private TestQueueServiceImpl testQueueService;

    /**
     * 测试每次输入1时，将一串随机的WXID加入队尾
     * @return
     */
    @PostMapping("/addQueue")
    public String addQueue(int add){
        String result="";
        if(add==1){
            int wxid= (int)((Math.random()*9+1)*100000);
            System.out.println("*******wxid:"+wxid);
            int resultNum=testQueueService.addQueue(wxid);

            if(resultNum>0){
                result="{\"status\":1}";
            }else {
                result="{\"status\":0}";
            }
        }else {
            result="{\"status\":0}";
        }
        return result;
    }

    /**
     * 测试队首的WXID将被移除时，前两秒内获取队首WXID
     * @return
     */
    @GetMapping("/showHeadOfQueue")
    public String showHeadOfQueue(){
        String result="";
        int wxid=testQueueService.showHeadOfQueue();
        if(wxid>0){
            result="{\"status\":1"+",\"wxid\":"+wxid+"}";
        }else {
            result="{\"status\":0}";
        }
        return result;
    }

    /**
     * 测试每4秒将队首的WXID移除
     * @return
     */
    @GetMapping("/removeHeadOfQueue")
    public String removeHeadOfQueue(){
        String result="";
        int resultNum=testQueueService.removeHeadOfQueue();

        if(resultNum>0){
            result="{\"status\":1}";
        }else {
            result="{\"status\":0}";
        }
        return result;
    }

    /**
     * 展示当前排队ID
     * @return
     */
    @GetMapping("/showQueue")
    public String showQueue(){
        String result="";
        List<Map<String,Object>> queueList=testQueueService.showQueue();
        if(queueList!=null){
            result="{\"status\":1"+",\"queueList\":"+queueList+"}";
        }else {
            result="{\"status\":0}";
        }
        return result;
    }

}
