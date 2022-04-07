package com.xingzhou.distributed.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName RMIClient.java
 * @Description TODO
 * @createTime 2022年04月07日 20:26:00
 */
public class RMIClient {
    public static void main(String[] args) {
        try {
//        1. 注册Registry实例.绑定端口
            Registry registry = LocateRegistry.createRegistry(9998);
//        2. 创建远程对象
            IUserService userService = new UserServiceImpl();
//        3. 将远程对象注册到RMI服务器上即(服务端注册表上)
            registry.rebind("userService", userService);
            System.out.println("---RMI服务端启动成功----");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

