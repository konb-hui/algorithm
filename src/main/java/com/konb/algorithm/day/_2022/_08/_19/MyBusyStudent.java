package com.konb.algorithm.day._2022._08._19;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-19 9:14
 * leetcode 1450 在既定时间做作业的学生人数
 */
public class MyBusyStudent {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i ++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count ++;
            }
        }

        return count;
    }

}
