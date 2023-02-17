package top100.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Description: 2-两数相加
 * @Author: Fang Xiaojun
 * @Date: 2023/2/17
 * @Version: V1.0
 */
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}
