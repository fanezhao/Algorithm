//给你一个链表的头节点 head ，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 10⁴] 
// -10⁵ <= Node.val <= 10⁵ 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
//
// 
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// Related Topics 哈希表 链表 双指针 👍 2025 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.ListNode;

import java.util.HashSet;

public class LC_141_环形链表 {
    public static void main(String[] args) {
        Solution solution = new LC_141_环形链表().new Solution();

        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        head.next = two;
        two.next = head;

        System.out.println(solution.hasCycle3(head));
        System.out.println(solution.cycleLength(head));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    /**
     * 暴力解法：双重循环大法
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;

            ListNode innerCurr = head;
            int pos = -1;
            while (innerCurr != null) {
                pos++;
                if (innerCurr == curr) {
                    if (next == innerCurr) {
                        return true;
                    }
                    break;
                }
                if (innerCurr == next) {
                    return true;
                }
                innerCurr = innerCurr.next;
            }
            curr = next;
        }
        return false;
    }

    /**
     * 官方解法1：用一个set保存走过的节点，如果每次保存的时候判断一下如果set中有就代表访问过
     * @param head
     * @return
     */
    public Boolean hasCycle1(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) {
                return true;
            }
            seen.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 官方解法2：快慢指针(龟兔赛跑套圈)
     * @param head
     * @return
     */
    public Boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }

    /**
     * 小灰算法中的解法
     * @param head
     * @return
     */
    public Boolean hasCycle3(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 求环长度
     * @param head
     * @return
     */
    public int cycleLength(ListNode head) {
        ListNode fast = head, slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return 0;
        }
        // 当两个指针在同一点相交时，让它们继续跑，直到下次相遇，此时对于慢指针走的长度刚好是一圈
        int length = 0;
        do {
            fast = fast.next.next;
            slow = slow.next;
            length++;
        } while (fast != slow);
        return length;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}