package com.zk.server.watcher;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

public class TreeListener implements TreeCacheListener {
    public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
        System.out.println("tree listener "+treeCacheEvent.toString());
    }
}

