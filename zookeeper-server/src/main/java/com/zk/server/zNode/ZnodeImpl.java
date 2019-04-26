package com.zk.server.zNode;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.Scanner;

public class ZnodeImpl implements ZnodeOperation {

    public boolean createPersistendZnode(String path, byte[] data, ZooKeeper zooKeeper) {
        try {
            zooKeeper.create(path,data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            this.existZnode(path,zooKeeper);
        } catch (KeeperException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean createEphemeralZnode(String path, byte[] data, ZooKeeper zooKeeper) {
        try {
            zooKeeper.create(path,data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (KeeperException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean createPersistendsequentialZnode(String path, byte[] data, ZooKeeper zooKeeper) {
        try {
            zooKeeper.create(path,data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        } catch (KeeperException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean createEphemeralsequentialZnode(String path, byte[] data, ZooKeeper zooKeeper) {
        try {
            zooKeeper.create(path,data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        } catch (KeeperException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean existZnode(String path, ZooKeeper zooKeeper) {
        try {
            zooKeeper.exists(path,true);
            return true;
        } catch (KeeperException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean addData(String path, byte[] data, ZooKeeper zooKeeper) {
        try {
            zooKeeper.setData(path,data,-1);
            return true;
        } catch (KeeperException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getData(String path, ZooKeeper zooKeeper) {
        try {
            byte[] datas = zooKeeper.getData(path,true,null);
            return new String(datas);
        } catch (KeeperException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {
//        ZnodeImpl.a(10);
//        System.out.println("-----------");
//        ZnodeImpl.b(10);
        ZnodeImpl.c();
    }

    public static void c(){
        Scanner scanner = new Scanner(System.in);
        String tar = scanner.next();
        char[] atr = tar.toCharArray();
        int length = atr.length;
        int strLength = 0;
        int start =0,end =0;
        for (int i=0;i<length;i++){
            boolean flag2=false;
            for (int j=length-1;j>i;j--){
                if (atr[i]==atr[j]&&i!=j){
                    flag2 = ZnodeImpl.hw(atr,i+1,j-1,length);
                    if(flag2){
                        start = i;
                        end = j;
                        int l = end-start;
                        if(strLength < l){
                            strLength = l;
                        }
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < start; i++) {

        }

//        char[] str1 = new char[atr.length];
//
//        for (int i = 0;i<length;i++){
//            str1[i]=atr[length-1-i];
//        }
//
//        for (int i = 0;i<length;i++){
//            if (atr[i]==str1[i]){
//
//            }
//        }


    }
    public static boolean hw(char[] atr,int first,int last,int length){
        boolean r;
        int f = 0;
        int l = 0;
        if(first>last){
            f=last;
            l=first;
        }else {
            f=first;
            l=last;
        }
        if (f==length||l<1){
            return false;
        }
        if(f==(l-1)){
            return true;
        }else {
            //判断下一位i是否相等
            if(atr[f]==atr[last]){
                r =  hw(atr,f+1,l-1,length);
            }else {
                r = false;
            }
        }
        return r;
    }
    public static void a(int a){
        Scanner scanner = new Scanner(System.in);
        int nium = scanner.nextInt();
        if (nium==0){
            a = 0;
        }else {
            a(a);
            a+=nium;
        }
        System.out.println(a);

    }

    public static  void b(int a){
        Scanner scanner = new Scanner(System.in);
        int temp = a;
        int i = 0;
        int[] arr = new int[10];
        while (scanner.hasNext()){
            int nium = scanner.nextInt();
            if (nium==0){
                a=0;
                arr[i]=a;

                break;
            }else {
                a +=nium;
                arr[i] = a;
                a=temp;
                i++;
            }
        }
        for (int n=i;n>=0;n--) {
            System.out.println(arr[n]);
        }


    }
}
