package com.zk.server;

import com.zk.server.watcher.MyWather;
import com.zk.server.zNode.ZnodeImpl;
import com.zk.server.zNode.ZnodeOperation;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {

        try {
            ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181",5000,new MyWather());
            ZnodeOperation znodeOperation = new ZnodeImpl();
            znodeOperation.createPersistendZnode("/config/node1","first 子节点".getBytes(),zooKeeper);
            Thread.sleep(1000*10);
            znodeOperation.addData("/config/node1","addDate".getBytes(),zooKeeper);
            System.out.println(znodeOperation.getData("/config/node1",zooKeeper));

            znodeOperation.createPersistendZnode("/config/node2","secend 子节点".getBytes(),zooKeeper);
            System.out.println(znodeOperation.getData("/config/node2",zooKeeper));
            System.out.println("end");
        } catch (IOException e) {
            System.out.println("连接zookeeper服务器失败");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("1    1");
        }
    }
}
