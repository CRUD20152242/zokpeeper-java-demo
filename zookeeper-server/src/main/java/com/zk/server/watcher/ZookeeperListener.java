package com.zk.server.watcher;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;

public class ZookeeperListener implements PathChildrenCacheListener {
    public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
        System.out.println("监视器启动------");
        System.out.println(pathChildrenCacheEvent.getData());
        System.out.println(pathChildrenCacheEvent.toString());
        System.out.println("----------end----------------");
    }
}
