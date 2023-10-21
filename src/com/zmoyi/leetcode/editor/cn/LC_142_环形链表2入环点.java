//给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：你是否可以使用 O(1) 空间解决此题？ 
//
// Related Topics 哈希表 链表 双指针 👍 2367 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.ListNode;

public class LC_142_环形链表2入环点 {
    public static void main(String[] args) {
        Solution solution = new LC_142_环形链表2入环点().new Solution();
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        head.next = two;
        two.next = head;

//        solution.detectCycle(head).print();


        int[] nums = new int[]{-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, -5};
        ListNode temp = new ListNode();
        ListNode idx24 = new ListNode();
        ListNode tail = new ListNode();
        for (int i = nums.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(nums[i]);
            temp.add(node);
            if (nums[i] == -24) {
                idx24 = node;
            }
            if (nums[i] == -5) {
                tail = node;
            }
        }
        tail.next = idx24;

        System.out.println(solution.detectCycle2(temp.next).val);
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

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 这种做法会超时(有点没想明白)
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        boolean hasCycle = false;

        // 第一轮快慢指针判断是否有环
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }

        // 第二轮：fast从头一步一步移动、slow从上次相交的地方移动，当前它们再次移动时就是环的入口
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}