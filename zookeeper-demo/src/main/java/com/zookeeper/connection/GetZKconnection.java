package com.zookeeper.connection;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.server.ConnectionBean;

public interface GetZKconnection {

    public ZooKeeper getZookeeper();

    public void test();
}
//
//    void rescur(int s){
//        int x;
//        cin>>x;
//        if(x==0){
//            s=0;
//        }else{
//            rescur(s);
//            s+=x;
//        }
//        cout s;
//    }
//while(x!=0){
//    s+=x;
//        }