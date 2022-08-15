package com.konb.algorithm.day._2022._08._15;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-15 15:18
 */
public class MyCircularDeque {

    private int size;
    private int currentSize;
    private int[] data;
    private int head;
    private int tail;

    public MyCircularDeque(int k) {
        size = k;
        currentSize = 0;
        head = -1;
        tail = -1;
        data = new int[size];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        if (currentSize == 0) {
            head = 0;
            tail = 0;
        } else {
            head --;
        }

        currentSize ++;

        if (head < 0) {
            head = size - 1;
        }
        data[head] = value;

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        if (currentSize == 0) {
            head = 0;
            tail = 0;
        } else {
            tail ++;
        }

        currentSize ++;

        if (tail >= size) {
            tail = 0;
        }
        data[tail] = value;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        head ++;
        currentSize --;

        if (currentSize == 0) {
            head = -1;
            tail = -1;
        }

        if (head >= size) {
            head = 0;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        tail --;
        currentSize --;

        if (currentSize == 0) {
            head = -1;
            tail = -1;
        }

        if (tail < 0) {
            tail = size - 1;
        }

        return true;
    }

    public int getFront() {
        return currentSize == 0 ? -1 : data[head];
    }

    public int getRear() {
        return currentSize == 0 ? -1 : data[tail];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize >= size;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertFront(2);
        myCircularDeque.getRear();

    }

}
