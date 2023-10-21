//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 3393 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.ListNode;

public class LC_206_反转链表 {
    public static void main(String[] args) {
        Solution solution = new LC_206_反转链表().new Solution();

        ListNode head1 = new ListNode(1);
        ListNode two = new ListNode(2);
        head1.next = two;
        head1.print();

        ListNode reverse = solution.reverseList(head1);
        reverse.print();
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
     * LC官方解法一：遍历法（双指针）
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 个人思路：用一个新节点去接收每次从head上拿下来的节点
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode node = new ListNode();
        while (head != null) {
            ListNode temp = head.next;
            addAfterCurr(node, head);
            head = temp;
        }
        return node.next;
    }

    private void addAfterCurr(ListNode curr, ListNode target) {
        if (curr.next == null) {
            curr.next = target;
            target.next = null;
        } else {
            target.next = curr.next;
            curr.next = target;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}