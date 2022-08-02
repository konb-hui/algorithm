package com.konb.algorithm.day._2022._08._02;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-02 16:51
 * leetcode 622 设计循环队列
 */
public class MyCircularQueue {

    private int size;
    private int currentSize;
    private int[] arr;
    private int head;

    public MyCircularQueue(int k) {
        size = k;
        arr = new int[size];
        head = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        currentSize ++;
        int index = head + currentSize;
        if (index >= size) {
            index -= size;
        }
        arr[index] = value;
        return true;
    }

    public boolean deQueue() {
        if (currentSize == 0) {
            return false;
        }
        currentSize --;
        head = head + 1 >= size ? -1 : head + 1;
        return true;
    }

    public int Front() {
        if (currentSize == 0) {
            return -1;
        }
        int index = head + 1;
        if (index >= size) {
            index -= size;
        }
        return arr[index];
    }

    public int Rear() {
        if (currentSize == 0) {
            return -1;
        }
        int index = head + currentSize;
        if (index >= size) {
            index -= size;
        }
        return arr[index];
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public boolean isFull() {
        return this.currentSize == this.size;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(2);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(3);
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(3);
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(3);
        myCircularQueue.deQueue();
        myCircularQueue.deQueue();
    }

}
