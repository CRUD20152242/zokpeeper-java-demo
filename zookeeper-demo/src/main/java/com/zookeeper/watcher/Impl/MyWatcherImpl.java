package com.zookeeper.watcher.Impl;

import com.zookeeper.watcher.MyWatcher;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class MyWatcherImpl implements Watcher , MyWatcher {
    public void process(WatchedEvent watchedEvent) {
        String path = watchedEvent.getPath();
        int state = watchedEvent.getState().getIntValue();
        int type = watchedEvent.getType().getIntValue();
        watchedEvent.getWrapper();
        watchedEvent.toString();
    }
}
