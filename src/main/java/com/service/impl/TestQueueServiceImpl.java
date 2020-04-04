package com.service.impl;

import com.dao.TestQueueDao;
import com.service.TestQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TestQueueServiceImpl
 * @Version 1.0
 * @Author dell
 * @Date 2020/4/3 20:28
 * @Description TODO
 * Modification User:
 * Modification Date:
 */

@Service
public class TestQueueServiceImpl implements TestQueueService {

    @Autowired
    private TestQueueDao testQueueDao;

    @Override
    public int addQueue(int wxid) {
        int result=testQueueDao.addQueue(wxid);
        return result;
    }

    @Override
    public int showHeadOfQueue() {
        return testQueueDao.showHeadOfQueue();
    }

    @Override
    public int removeHeadOfQueue() {
        int result=testQueueDao.removeHeadOfQueue();
        return result;
    }

    @Override
    public List<Map<String, Object>> showQueue() {
        List<Map<String, Object>> queueList=testQueueDao.showQueue();
        return queueList;
    }
}
