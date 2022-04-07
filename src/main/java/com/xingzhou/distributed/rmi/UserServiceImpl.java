package com.xingzhou.distributed.rmi;

import com.google.common.collect.Maps;

import java.rmi.RemoteException;
import java.util.HashMap;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2022年04月07日 20:38:00
 */
public class UserServiceImpl implements IUserService{

    HashMap<Object, User> userMap = Maps.newHashMap();
    public UserServiceImpl(){
        super();
        User user1 = User.builder()
                .id(1001)
                .name("zhangSan")
                .age((short) 12)
                .build();
        User user2 = User.builder()
                .id(1002)
                .name("liSi")
                .age((short) 13)
                .build();
        userMap.put(user1.getId(), user1);
        userMap.put(user2.getId(), user2);
    }

    @Override
    public User getById(int id) throws RemoteException {
        return userMap.get(id);
    }
}
