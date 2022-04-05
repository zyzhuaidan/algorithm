package com.xingzhou.config.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Event.java
 * @Description TODO
 * @createTime 2022年04月05日 11:00:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Long id;
    private String name;
    private Integer age;
}
