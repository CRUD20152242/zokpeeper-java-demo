package com.zk.server.watcher;

import org.apache.curator.framework.recipes.cache.NodeCacheListener;

public class NodeWatcher implements NodeCacheListener {
    public void nodeChanged() throws Exception {
        System.out.println("节点监控启动");
    }
}
