package com.service;

import java.util.List;
import java.util.Map;

public interface TestQueueService {

    public int addQueue(int wxid);

    public int showHeadOfQueue();

    public int removeHeadOfQueue();

    public List<Map<String,Object>> showQueue();
}
