package top100.part1;

/**
 * @Description: 4-寻找两个正序数组的中位数（归并排序/二分查找）
 * @Author: Fang Xiaojun
 * @Date: 2023/2/20
 * @Version: V1.0
 */
public class FindMedianSortedArrays {

    public static int[] mergeSortedArray(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, i = 0, j = 0, k = 0;
        int[] res = new int[len1 + len2];
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else if (nums2[j] < nums1[i]) {
                res[k++] = nums2[j++];
            } else {
                res[k++] = nums1[i++];
                res[k++] = nums2[j++];
            }
        }
        while (i < len1) {
            res[k++] = nums1[i++];
        }
        while (j < len2) {
            res[k++] = nums2[j++];
        }
        return res;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num = mergeSortedArray(nums1, nums2);
        int len = num.length;
        return len % 2 == 0 ? (num[len/2-1] + num[len/2]) / 2.0 : num[len/2];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
