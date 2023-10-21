//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 3321 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.ListNode;

public class LC_21_合并两个有序链表 {
    public static void main(String[] args) {
        Solution solution = new LC_21_合并两个有序链表().new Solution();
        ListNode list1 = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(4);
        list1.next = two;
        two.next = three;

        ListNode list2 = new ListNode(1);
        ListNode four = new ListNode(3);
        ListNode five = new ListNode(4);
        list2.next = four;
        four.next = five;

        solution.mergeTwoLists(list1, list2).print();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 准备一个哨兵节点用于接收分别来自两个链表的最小的那个节点。
     * 如果哪个节点上的最小节点被放到哨兵节点后，则指针身后推进一步，直到为空为止。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode curr = node;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 == null ? list2 : list1;
        return node.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}