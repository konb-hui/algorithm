package com.konb.algorithm.day._20220726;

import org.w3c.dom.Node;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-26 9:19
 * leetcode 1206 设计跳表
 */
public class Skiplist {

    static class Node{
        public int value;
        public Node(int value) {
            this.value = value;
        }
        public Node() {

        }
        public Node left;
        public Node right;
        public Node up;
        public Node down;
    }

    public Node head;

    public Skiplist() {

    }

    public boolean search(int target) {
        return mySearch(target) != null;
    }

    private Node mySearch(int num) {
        Node node = head;
        if (node != null) {
            if (node.value == num) {
                addNew(node);
                return node.up;
            } else if (node.value < num) {
                while (node != null) {
                    while (node.right != null && node.right.value <= num) {
                        if (node.right.value == num) {
                            addNew(node.right);
                            return node.right.up;
                        }
                        node = node.right;
                    }
                    node = node.down;
                }
            } else {
                while (node != null) {
                    while (node.left != null && node.left.value >= num) {
                        if (node.left.value == num) {
                            addNew(node.left);
                            return node.left.up;
                        }
                        node = node.left;
                    }
                    node = node.down;
                }
            }
        }
        return null;
    }

    private void addNew(Node node) {
        Node n = new Node(node.value);
        node.up = n;
        n.down = node;

        Node left = node.left;
        while (left != null) {
            if (left.up != null) {
                left.up.right = n;
                n.left = left.up;
                break;
            }
            left = left.left;
        }

        if (n.left == null) {
            head = n;
        }

        Node right = node.right;
        while (right != null) {
            if (right.up != null) {
                right.up.left = n;
                n.right = right.up;
                break;
            }
            right = right.right;
        }
    }

    public void add(int num) {
        if (head == null) {
            head = new Node(num);
            return;
        }

        Node node = head;

        boolean flag = false;
        while (node.down != null) {
            node = node.down;
            flag = true;
        }
        if (num <= node.value) {
            while (node.left != null) {
                if (num <= node.left.value) {
                    node = node.left;
                } else {
                    Node node1 = new Node(num);
                    node.left.right = node1;
                    node1.left = node.left;
                    node.left = node1;
                    node1.right = node;
                    return;
                }
            }
            Node node1 = new Node(num);
            node.left = node1;
            node1.right = node;
            if (! flag) {
                head = node1;
            }
        } else {
            while (node.right != null) {
                if (num > node.right.value) {
                    node = node.right;
                } else {
                    Node node1 = new Node(num);
                    node.right.left = node1;
                    node1.right = node.right;
                    node.right = node1;
                    node1.left = node;
                    return;
                }
            }
            Node node1 = new Node(num);
            node.right = node1;
            node1.left = node;
        }
    }

    public boolean erase(int num) {
        Node node = mySearch(num);
        if (node == null) {
            return false;
        }
        while (node != null) {
            if (node.left != null) {
                node.left.right = node.right;
            }
            if (node.right != null) {
                if (head == node) {
                    head = head.right;
                }
                node.right.left = node.left;
            }
            node.right = null;
            node.left = null;
            if (head == node) {
                head = head.down;
                while (head.left != null) {
                    head = head.left;
                }
            }
            node = node.down;
        }
        return true;
    }

    public static void doSome(Skiplist skiplist, String s, int value) {
        switch (s) {
            case "add": skiplist.add(value); break;
            case "search": skiplist.search(value); break;
            case "erase": skiplist.erase(value); break;
            default: break;
        }
    }

//["Skiplist","add","add","add","add","add","add","add","add","add","erase","search","add","erase","erase","erase","add","search","search","search","erase","search","add","add","add","erase","search","add","search","erase","search","search","erase","erase","add","erase","search","erase","erase","search","add","add","erase","erase","erase","add","erase","add","erase","erase","add","add","add","search","search","add","erase","search","add","add","search","add","search","erase","erase","search","search","erase","search","add","erase","search","erase","search","erase","erase","search","search","add","add","add","add","search","search","search","search","search","search","search","search","search"]
//        [[],[16],[5],[14],[13],[0],[3],[12],[9],[12],[3],[6],[7],[0],[1],[10],[5],[12],[7],[16],[7],[0],[9],[16],[3],[2],[17],[2],[17],[0],[9],[14],[1],[6],[1],[16],[9],[10],[9],[2],[3],[16],[15],[12],[7],[4],[3],[2],[1],[14],[13],[12],[3],[6],[17],[2],[3],[14],[11],[0],[13],[2],[1],[10],[17],[0],[5],[8],[9],[8],[11],[10],[11],[10],[9],[8],[15],[14],[1],[6],[17],[16],[13],[4],[5],[4],[17],[16],[7],[14],[1]]

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        String[] methods = new String[] {"add","add","add","add","add","add","add","add","add","erase","search","add","erase","erase","erase","add","search","search","search","erase","search","add","add","add","erase","search","add","search","erase","search","search","erase","erase","add","erase","search","erase","erase","search","add","add","erase","erase","erase","add","erase","add","erase","erase","add","add","add","search","search","add","erase","search","add","add","search","add","search","erase","erase","search","search","erase","search","add","erase","search","erase","search","erase","erase","search","search","add","add","add","add","search","search","search","search","search","search","search","search","search"};
        int[] values = new int[] {16,5,14,13,0,3,12,9,12,3,6,7,0,1,10,5,12,7,16,7,0,9,16,3,2,17,2,17,0,9,14,1,6,1,16,9,10,9,2,3,16,15,12,7,4,3,2,1,14,13,12,3,6,17,2,3,14,11,0,13,2,1,10,17,0,5,8,9,8,11,10,11,10,9,8,15,14,1,6,17,16,13,4,5,4,17,16,7,14,1};
        System.out.println(values.length);

        for (int i = 0; i < methods.length; i ++) {
            doSome(skiplist, methods[i], values[i]);
        }
    }

}
