package com.konb.algorithm.day._20220724;

/**
 * @author konb
 * @version 1.0
 * @date 2022/7/24 15:03
 * leetcode 1184 公交站间的距离
 */

public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int a = 0;
        int b = 0;

        int i = start;
        while (i != destination) {
            a += distance[i];
            i ++;
            if (i == distance.length){
                i = 0;
            }
        }

        int j = start - 1 < 0 ? distance.length - 1 : start - 1;
        while (j != destination) {
            b += distance[j];
            j --;
            if (j < 0) {
                j = distance.length - 1;
            }
        }
        b += distance[destination];

        return Math.min(a, b);

    }

    public static void main(String[] args) {
        DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();
        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3));
    }

}
