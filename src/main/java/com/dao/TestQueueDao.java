package com.dao;

import java.util.List;
import java.util.Map;

public interface TestQueueDao {

    public int addQueue(int wxid);

    public int showHeadOfQueue();

    public int removeHeadOfQueue();

    public List<Map<String,Object>> showQueue();

}
