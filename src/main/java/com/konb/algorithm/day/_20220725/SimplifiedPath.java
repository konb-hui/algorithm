package com.konb.algorithm.day._20220725;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-25 15:40
 * leetcode 71 简化路径
 */
public class SimplifiedPath {

    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();

        StringBuilder stringBuilder = new StringBuilder();
        path = path + "/";
        for (int i = 1; i < path.length(); i ++) {
            char a = path.charAt(i);
            if (a == '/') {
                if (stringBuilder.length() > 0) {
                    String s = stringBuilder.reverse().toString();
                    if ("..".equals(s) && deque.size() > 0) {
                        deque.pop();
                    } else if (! ".".equals(s) && ! "..".equals(s)) {
                        deque.push(s);
                    }
                    stringBuilder = new StringBuilder();
                }
            } else {
                stringBuilder.append(a);
            }
        }

        stringBuilder = new StringBuilder();
        while (deque.peek() != null) {
            stringBuilder.append(deque.pop());
            stringBuilder.append("/");
        }

        if (stringBuilder.length() == 0) {
            return "/";
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        SimplifiedPath simplifiedPath = new SimplifiedPath();
        System.out.println(simplifiedPath.simplifyPath("/a/./b/../../c/"));
    }

}
