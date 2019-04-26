package com.zk.server;


import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CuratorTestTest {
    private static String host = "127.0.0.1:2181";
    public CuratorFramework zkClient;
    @Before
    public void init() {
        zkClient = CuratorFrameworkFactory.newClient(host, new RetryNTimes(10, 1000) {
        });
        zkClient.start();
    }

    @Test
    public void getPayh() {

        try {
            List<String> pathsResult= zkClient.getChildren().forPath("/");
            pathsResult.remove(0);
            List<String> paths =pathsResult;
            for (String path:paths
                 ) {
                System.out.println(path);
            }
         } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getAllPaths(CuratorFramework zkClient,String path){
        if(StringUtils.isEmpty(path)){
            return "";
        }else {
            try {
                String result = zkClient.checkExists().forPath(path).toString();
            } catch (Exception e) {
                System.out.println("检查出错");
                e.printStackTrace();
            }
        }

        return null;
    }

    @Test
    public void  checkPath(){
        List<String> paths= new ArrayList<String>();
        getpaths(zkClient,"/",paths);
        System.out.println("all paths are : ");
        for (String path:paths) {
            System.out.println(path);
        }
    }


    public void getpaths(CuratorFramework zkClient,String root,List<String> myPaths){
        myPaths.add(root);
        List<String> paths= getChildNode(zkClient,root);
        if(null==paths){
            return;
        }else {
            for (String path1:paths) {
                root = "/".equals(root)?root+path1:root+"/"+path1;
                getpaths(zkClient,root,myPaths);
            }
        }
    }

//    判断是否有子节点
    public List<String> getChildNode(CuratorFramework zkClient,String path){
        try {
            List<String> result = zkClient.getChildren().forPath(path);
           if ("zookeeper".equals(result.get(0))){
               result.remove(0);
           }
            return result.size()==0?null:result;
        } catch (Exception e) {
            System.out.println("别闹");
        }
        return null;
    }
@Test
    public void testList(){
        String str="";
    for (int i = 0; i <4 ; i++) {
        str+="hello";
    }
    System.out.println(str);
//        List<String> list = new ArrayList<String>(10);
//        list.add("0");
//        list.add("1");
//        list.add("2");
//
//        for (String li:list){
//            System.out.println(li);
//        }
//
//        list.remove(0);
//        System.out.println(list.get(0));
    }
}
