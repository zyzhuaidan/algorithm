package com.xingzhou.algorithm.y22m3w4;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Code03_graphDFS.java
 * @Description TODO
 * @createTime 2022年03月21日 11:18:00
 */
public class Code03_graphDFS {
    public void graphDFS(Node start){
        if(start == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(start);
        set.add(start);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            for(Node next:cur.nexts){
                if(!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
