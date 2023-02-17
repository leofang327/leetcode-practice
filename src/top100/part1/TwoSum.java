package top100.part1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1-两数之和
 * @Author: Fang Xiaojun
 * @Date: 2023/2/17
 * @Version: V1.0
 */
public class TwoSum {

    // 暴力双循环
    public static int[] twoSum1(int[] nums, int target) {
        int i, j, len = nums.length;
        for (i = 0; i < len; ++i) {
            for (j = i+1; j < len; ++j) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }

    // hash表空间换时间
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum2(nums, target);
        Arrays.stream(result).forEach(System.out::println);
    }

}