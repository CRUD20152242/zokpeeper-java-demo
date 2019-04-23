package com.zk.server;

import com.google.gson.Gson;
import com.zk.server.Model.DataPo;
import com.zk.server.watcher.MyWather;
import com.zk.server.zNode.ZnodeImpl;
import com.zk.server.zNode.ZnodeOperation;
import org.apache.zookeeper.ZKUtil;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeperMain;
import org.apache.zookeeper.jmx.ZKMBeanInfo;
import org.apache.zookeeper.server.ZooKeeperServerBean;
import org.apache.zookeeper.server.ZooKeeperServerListener;
import org.apache.zookeeper.server.ZooKeeperThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Start {
    private static final Logger logger = LoggerFactory.getLogger(Start.class);


    public static void main(String[] args) {
        ZooKeeper zooKeeper;
        ZnodeOperation znodeOperation  = new ZnodeImpl();
            try {
                zooKeeper = new ZooKeeper("127.0.0.1:2181",5000,new MyWather());
                System.out.println("first 连接zookeeper服务端成功");

                znodeOperation.createPersistendZnode("/config","我这仅仅时测试".getBytes(),zooKeeper);
                System.out.println("first 成功创建节点/config");
//                boolean switch1 = znodeOperation.createPersistendZnode("/config/switch","我".getBytes(),zooKeeper);
//                System.out.println(switch1);
                String myData = znodeOperation.getData("/config",zooKeeper);

                System.out.println("first /config 结点的数据是："+myData);

//                DataPo dataPo = new DataPo();
//                dataPo.setFirstName("xu");
//                dataPo.setLastName("yd");
//                Gson gson = new Gson();
//                String data = gson.toJson(dataPo);
//                znodeOperation.addData("/config",data.getBytes(),zooKeeper);
//                String myDataPo = znodeOperation.getData("/config",zooKeeper);
//
//                System.out.println("/config 结点的数据是："+myDataPo);
//                DataPo dataPo1 = new DataPo();
//                dataPo1 = gson.fromJson(myDataPo,dataPo1.getClass());
//
//                System.out.println("我们最终的数据是"+dataPo1);
//                /**
//                 * 节点存储k-v形式的数据
//                 */
//                HashMap<String,String> hashMap = new HashMap<String, String>(50);
//                hashMap.put("path","/config/test1");
//                hashMap.put("user","user1|user2");
//                String hash = gson.toJson(hashMap);
//
//                znodeOperation.addData("/config/switch",hash.getBytes(),zooKeeper);
//                System.out.println("准备获取hashMap 形式存储的数据");
//                String result = znodeOperation.getData("/config/switch",zooKeeper);
//                System.out.println("结果是："+gson.fromJson(result,HashMap.class).get("path"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        try {
            Thread.sleep(100000000000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
