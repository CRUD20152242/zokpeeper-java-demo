package com.zk.server.zNode;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ZnodeImpl implements ZnodeOperation {

    public boolean createPersistendZnode(String path, byte[] data, ZooKeeper zooKeeper) {
        try {
            zooKeeper.create(path,data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
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
}
