package com.service.impl;

import com.dao.TestDao;
import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName TestServiceImpl
 * @Version 1.0
 * @Author dell
 * @Date 2020/4/3 18:35
 * @Description TODO
 * Modification User:
 * Modification Date:
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public String getStr() {
        return testDao.getStr();
    }

}
