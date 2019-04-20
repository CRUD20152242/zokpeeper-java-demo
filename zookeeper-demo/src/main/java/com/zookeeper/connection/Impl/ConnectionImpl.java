package com.zookeeper.connection.Impl;

import com.zookeeper.connection.GetZKconnection;
import com.zookeeper.watcher.Impl.MyWatcherImpl;
import com.zookeeper.watcher.MyWatcher;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.server.ConnectionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ConnectionImpl  implements GetZKconnection {
    private Watcher myWatcher = new MyWatcherImpl();
    public final Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 构造函数有很多，分别是
     * 1.服务器集群ip:端口号 多个ip逗号分割  还可以最后指定操作的目录，
     * ip1:port1,ip1:port1ip1:port1/zkroot 那么一切操作都会基于zkroot下进行操作
     * 2.session-Time 会话超时时间  时间单位是ms 超过这个时间没有心跳检测 就会断开这个连接
     * 3. watcher 监视器
     * 4. sessionId
     * 5. sessionPassword
     * 6. 是否只读
     * <p>
     * sessionID和sessionPassword 可以唯一确定一个会话  可以通过zookeeper.getSessionId
     * 与zookeeper.getSessionPassword  获取
     */
    public ZooKeeper getZookeeper(){
        logger.info("开始准备实例化zookeeper实例");
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper("127.0.0.1:1281",5000,myWatcher);
        } catch (IOException e) {
            logger.info("zk与客户端连接网络异常 地址是127.0.0.1:1281");
            e.printStackTrace();
        }
        return zooKeeper;
    }

    public void test() {

    }

    public String getConstructorDoc(){
        return "/**\n" +
                "     * 构造函数有很多，分别是\n" +
                "     * 1.服务器集群ip:端口号 多个ip逗号分割  还可以最后指定操作的目录，\n" +
                "     * ip1:port1,ip1:port1ip1:port1/zkroot 那么一切操作都会基于zkroot下进行操作\n" +
                "     * 2.session-Time 会话超时时间  时间单位是ms 超过这个时间没有心跳检测 就会断开这个连接\n" +
                "     * 3. watcher 监视器\n" +
                "     * 4. sessionId\n" +
                "     * 5. sessionPassword\n" +
                "     * 6. 是否只读\n" +
                "     *\n" +
                "     * sessionID和sessionPassword 可以唯一确定一个会话  可以通过zookeeper.getSessionId\n" +
                "     * 与zookeeper.getSessionPassword  获取\n" +
                "     */";
    }

}
