package com.zk.server.zNode;


import org.apache.zookeeper.ZooKeeper;

public interface ZnodeOperation {
    //ephemeral 临时的  sequential有序的  persistend  持久的

    /**
     * 创建唯一持久节点
     * @return
     */
    boolean createPersistendZnode(String path, byte[] data, ZooKeeper zooKeeper);

    /**
     * 创建临时唯一节点
     * @param path
     * @param data
     * @return
     */
    boolean createEphemeralZnode(String path,byte[] data,ZooKeeper zooKeeper);

    /**
     * 创建持久有序节点
     * @param path
     * @param data
     * @return
     */
    boolean createPersistendsequentialZnode(String path,byte[] data,ZooKeeper zooKeeper);

    /**
     * 创建临时有序节点
     * @param path
     * @param data
     * @return
     */
    boolean createEphemeralsequentialZnode(String path,byte[] data,ZooKeeper zooKeeper);

    /**
     * 检测指定路径是否存在
     * @param path
     * @return
     */
    boolean existZnode(String path,ZooKeeper zooKeeper);

    /**
     * 给指定path 设置指定数据
     * @param path
     * @param data
     * @return
     */
    boolean addData(String path,byte[] data,ZooKeeper zooKeeper);

    /**
     * 获取数据
     * @param path
     * @return
     */
    String getData(String path,ZooKeeper zooKeeper);

}
