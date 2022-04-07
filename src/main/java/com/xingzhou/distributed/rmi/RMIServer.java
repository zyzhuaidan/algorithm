package com.xingzhou.distributed.rmi;

import com.alibaba.fastjson.JSON;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName RMIServer.java
 * @Description TODO
 * @createTime 2022年04月07日 20:25:00
 */
public class RMIServer {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9998);
        IUserService userService = (IUserService)registry.lookup("userService");
        User user = userService.getById(1002);
        System.out.println(JSON.toJSON(user));
    }
}
