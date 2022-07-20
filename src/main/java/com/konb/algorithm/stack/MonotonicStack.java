package com.konb.algorithm.stack;

import org.w3c.dom.Node;

import java.util.Stack;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-04 14:19
 */
public class MonotonicStack {

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }

    public int[] getBigArray(int[] arr) {
        int[] r = new int[arr.length];
        Stack<Node> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i --) {
            if (stack.isEmpty() || stack.peek().getValue() >= arr[i]) {
                stack.push(new Node(i, arr[i]));
                continue;
            }
            r[stack.pop().getIndex()] = arr[i];
            stack.push(new Node(i, arr[i]));
        }

        while (! stack.isEmpty()) {
            Node node = stack.pop();
            r[node.getIndex()] = -1;
        }

        return r;
    }

    public static void main(String[] args) {
        MonotonicStack stack = new MonotonicStack();
        for (int a : stack.getBigArray(new int[]{1, 2, 1, 5, 7, 6, 4})) {
            System.out.print(a);
            System.out.print(" ");
        }
    }

}
