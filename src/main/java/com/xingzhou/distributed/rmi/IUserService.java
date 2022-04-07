package com.xingzhou.distributed.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @title
 * @description
 * @author xingzhou
 * @updateTime 2022/4/7 8:28 下午
 * @throws
 */
public interface IUserService extends Remote {
    User getById(int id) throws RemoteException;
}
