package com.zk.server.watcher;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyWather implements Watcher {
//    private final Logger logger = LoggerFactory.getLogger(getClass());
    public void process(WatchedEvent watchedEvent) {
        String infos = watchedEvent.toString();
//        logger.info("监视器触发："+infos);
        System.out.println("监视器触发："+infos);

        System.out.println();
    }
}
