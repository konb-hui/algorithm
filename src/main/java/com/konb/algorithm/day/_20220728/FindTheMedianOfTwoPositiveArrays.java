package com.konb.algorithm.day._20220728;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-28 11:23
 * leetcode 4 寻找两个正序数组的中位数
 */
public class FindTheMedianOfTwoPositiveArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        boolean flag = (length1 + length2) % 2 == 0;
        int mid = (length1 + length2) / 2 + 1;

        int i = 0,j = 0, count = 0;
        int l = 0, r = 0;

        while (true) {
            if (i >= length1) {
                int len = mid - count;
                if (len == 1) {
                    r = nums2[j];
                    break;
                } else if (len > 1){
                    l = nums2[j + len - 2];
                    r= nums2[j + len - 1];
                    break;
                }
            } else if (j >= length2) {
                int len = mid - count;
                if (len == 1) {
                    r = nums1[i];
                    break;
                } else if (len > 1){
                    l = nums1[i + len - 2];
                    r= nums1[i + len - 1];
                    break;
                }
            }
            if (nums1[i] <= nums2[j]) {
                count ++;
                if (count == mid - 1) {
                    l = nums1[i];
                } else if (count == mid) {
                    r = nums1[i];
                    break;
                }
                i ++;
            } else {
                count ++;
                if (count == mid - 1) {
                    l = nums2[j];
                } else if (count == mid) {
                    r = nums2[j];
                    break;
                }

                j ++;
            }
            if (count >= mid) {
                break;
            }
        }

        if (flag) {
            return (r + l) / 2.0;
        }
        return r / 1.0;
    }

    public static void main(String[] args) {
        FindTheMedianOfTwoPositiveArrays findTheMedianOfTwoPositiveArrays = new FindTheMedianOfTwoPositiveArrays();
        System.out.println(findTheMedianOfTwoPositiveArrays.findMedianSortedArrays(new int[]{}, new int[]{}));
    }

}
