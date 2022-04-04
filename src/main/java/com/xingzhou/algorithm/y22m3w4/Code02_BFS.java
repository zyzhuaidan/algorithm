package com.xingzhou.algorithm.y22m3w4;

import java.util.*;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Code02_BFS.java
 * @Description TODO
 * @createTime 2022年03月21日 10:59:00
 */
public class Code02_BFS {
    public void graphBFS(Node start) {
        if (start == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
