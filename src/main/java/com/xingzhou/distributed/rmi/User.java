package com.xingzhou.distributed.rmi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2022年04月07日 20:29:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private Integer id;
    private String name;
    private Short age;
}
