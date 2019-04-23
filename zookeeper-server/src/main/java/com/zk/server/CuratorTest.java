package com.zk.server;

import com.zk.server.watcher.NodeWatcher;
import com.zk.server.watcher.TreeListener;
import com.zk.server.watcher.ZookeeperListener;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.retry.RetryNTimes;

/**
 * 非官方提供的zookeeper客户端实战测试
 */
public class CuratorTest {
    private static String host = "127.0.0.1:2181";

    public static void main(String[] args) {
        CuratorFramework zkClient  = CuratorFrameworkFactory.newClient(host, new RetryNTimes(10,1000) {
        });

        zkClient.start();
        System.out.println("连接zookeeper服务器成功");

        try {
            zkClient.create().creatingParentsIfNeeded().forPath("/config/curatorT1","数据1".getBytes());


            String result = new String(zkClient.getData().forPath("/config/curatorT1"));

            System.out.println(result);
            System.out.println("创建path 并且获取数据成功 开始测试curator的监视器是否也是一次性的");

            /**
             * 本监视器只监控指定节点的孩子节点
             */
            PathChildrenCache watcher  = new PathChildrenCache(zkClient,"/config",false);
            watcher.getListenable().addListener(new ZookeeperListener());
            watcher.start();

            /**
             * 这个监视器可以监视我们的节点
             */
            NodeCache nodeWatcher = new NodeCache(zkClient,"/config",false);
            nodeWatcher.getListenable().addListener(new NodeWatcher());
            nodeWatcher.start();
            /**
             * 这个监视器整合了上面两个监视器
             */
            TreeCache treeCache = new TreeCache(zkClient,"/config");
            treeCache.getListenable().addListener(new TreeListener());
            treeCache.start();
            Thread.sleep(1000*60*60);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
