package com.konb.algorithm.day._20220725;

import com.konb.algorithm.day.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-25 10:20
 * leetcode 919 完全二叉树插入器
 */
public class CBTInserter {

    TreeNode root;
    Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        insertQueue(root);
    }

    public void insertQueue(TreeNode root) {
        queue.add(root);

        while (true) {
            TreeNode peek = queue.peek();
            if (peek.left != null && peek.right != null) {
                queue.offer(peek.left);
                queue.offer(peek.right);
                queue.poll();
            } else {
                if (peek.left != null) {
                    queue.offer(peek.left);
                } else if (peek.right != null) {
                    queue.offer(peek.right);
                }
                break;
            }
        }
    }

    public int insert(int val) {
        TreeNode peek = queue.peek();
        TreeNode node = new TreeNode(val);

        if (peek.left == null) {
            peek.left = node;
        } else if (peek.right == null) {
            peek.right = node;
        }

        queue.offer(node);
        if (peek.left != null && peek.right != null) {
            queue.poll();
        }
        return peek.val;
    }

    public TreeNode get_root() {
        return this.root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        CBTInserter cbtInserter = new CBTInserter(root);
        cbtInserter.insert(2);
        cbtInserter.insert(3);
        cbtInserter.insert(4);
        cbtInserter.get_root();
    }

}
