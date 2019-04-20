package com.zookeeper.connection;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.server.ConnectionBean;

public interface GetZKconnection {

    public ZooKeeper getZookeeper();

    public void test();
}
