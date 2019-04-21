package com.zk.server;

import com.google.gson.Gson;
import com.zk.server.Model.DataPo;
import com.zk.server.watcher.MyWather;
import com.zk.server.zNode.ZnodeImpl;
import com.zk.server.zNode.ZnodeOperation;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Start {
    private static final Logger logger = LoggerFactory.getLogger(Start.class);


    public static void main(String[] args) {
        ZooKeeper zooKeeper;
        ZnodeOperation znodeOperation  = new ZnodeImpl();
            try {
                zooKeeper = new ZooKeeper("127.0.0.1:2181",5000,new MyWather());
                System.out.println("连接zookeeper服务端成功");

                znodeOperation.createEphemeralZnode("/config","我这仅仅时测试".getBytes(),zooKeeper);
                System.out.println("成功创建节点/config");

                String myData = znodeOperation.getData("/config",zooKeeper);

                System.out.println("/config 结点的数据是："+myData);

                DataPo dataPo = new DataPo();
                dataPo.setFirstName("xu");
                dataPo.setLastName("yd");
                Gson gson = new Gson();
                String data = gson.toJson(dataPo);
                znodeOperation.addData("/config",data.getBytes(),zooKeeper);
                String myDataPo = znodeOperation.getData("/config",zooKeeper);

                System.out.println("/config 结点的数据是："+myDataPo);
                DataPo dataPo1 = new DataPo();
                dataPo1 = gson.fromJson(myDataPo,dataPo1.getClass());

                System.out.println("我们最终的数据是"+dataPo1);
            } catch (IOException e) {
                e.printStackTrace();
            }


    }

}
