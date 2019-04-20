package com.zookeeper.connection.Impl;

import com.zookeeper.connection.GetZKconnection;
import com.zookeeper.watcher.Impl.MyWatcherImpl;
import com.zookeeper.watcher.MyWatcher;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.ConnectionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ConnectionImpl  implements GetZKconnection {
    private Watcher myWatcher = new MyWatcherImpl();
    public final Logger logger = LoggerFactory.getLogger(getClass());
    public volatile  ZooKeeper zooKeeper = null;
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

    public static void main(String[] args) throws Exception{
        Watcher myWatcher1 = new MyWatcherImpl();
        GetZKconnection getZKconnection = new ConnectionImpl();
        ZooKeeper zooKeeper = getZKconnection.getZookeeper();
//        zooKeeper.addAuthInfo("","");  //客户端啊提交自己的权限
//        zooKeeper.close();

//      1.  各个参数对应的含义是  路径，数据，权限 ，节点类型， 另一个参数是异步化创建
//        public void create(String path, byte[] data, List<ACL> acl, CreateMode createMode, StringCallback cb, Object ctx)
//        使用例子
//        zooKeeper.create("p1","你好".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//      2. 删除指定路径下的节点  version=-1 意思是删除所有版本下的这个znode,其余的值是删除对应的版本 另一个版本是异步化删除
//        zooKeeper.delete("",1);
//        zooKeeper.delete("/p2",-1);
//      3. 检测指定路径下的节点是否存在
//         参数有 路径，是否监控这个节点（监控器）
//        zooKeeper.exists("/p1",true);  是否监控  默认的监控是我们创建连接时的监听器
//        zooKeeper.exists("/p1",myWatcher1); 配置我们自己的监听器
//       4.获取指定path下的所有节点
//        zooKeeper.getChildren();
//        zooKeeper.getChildren("p2",false);
//       5.获取某个目录节点的访问权限列表
//        zooKeeper.getACL();
//      6.获取指定节点的数据
//         参数分别时路径  是否监控 节点状态等信息（用来匹配）
//        zooKeeper.getData("p3",false,new Stat());
//       7. zookeeper的事务操作
//        zooKeeper.transaction();
//       8. 将多个操作合并成一个操作  合并后的操作也是原子性的
//        zooKeeper.multi();

    }
}
