# zookpeeper-java-demo
zookeeper java客户端的使用及封装

#环境准备
下载zookeeper的压缩包 地址：http://mirror.bit.edu.cn/apache/zookeeper/

客户端 maven

            <dependency>
                <groupId>org.apache.zookeeper</groupId>
                <artifactId>zookeeper</artifactId>
                <version>${zk.ver}</version>
                <!--<type>pom</type>-->
            </dependency>
            
# 步骤
## 1 启动zookeeper服务端
## 2 通过构造函数创建与zookeeper服务端的连接
  zooKeeper = new ZooKeeper("127.0.0.1:1281",5000,myWatcher);
## 3 通过watcher来监听服务端的改变
public class MyWatcherImpl implements Watcher , MyWatcher {
    public void process(WatchedEvent watchedEvent) {
        String path = watchedEvent.getPath();
        int state = watchedEvent.getState().getIntValue();
        int type = watchedEvent.getType().getIntValue();
        watchedEvent.getWrapper();
        watchedEvent.toString();
    }
}

#zookeeper实例中常用方法及参数的含义
 public void create(String path, byte[] data, List<ACL> acl, CreateMode createMode, StringCallback cb, Object ctx)
 参数的含义分别是  创建的路径，数据，权限，节点类型
 StringCallback cb, Object ctx  是异步调用时使用的  cb接口 我们需要重写他 ctx 传递给异步调用时候的对象


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



