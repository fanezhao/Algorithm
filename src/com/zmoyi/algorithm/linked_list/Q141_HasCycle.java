package com.zmoyi.algorithm.linked_list;

/**
 * 环形链表
 */
public class Q141_HasCycle {

    /*

给你一个链表的头节点 head ，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。

如果链表中存在环 ，则返回 true 。 否则，返回 false 。

     */

    /**
     * 数学上的追及问题，一个环形跑道上，一个人跑的快，一个人跑的慢，在某一时刻，快的人一定会追上慢的人并超越。
     * 所以这个使用了两个指针，分别表示一个人跑的快，一个人跑的慢。
     * 跑的快的每次步进2，慢的每次步进1，当前两个指针指向同一个节点时，代表链表有环。
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
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
    public static int cycleLen(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        // 相遇次数
        int i = 0;
        // 环长度
        int step = 0;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                i++;
            }

            // 第一次相遇之后，每次循环一次步数+1
            if (i == 1) {
                step++;
            }
            // 第二次相遇时，步数即时环的长度
            if (i == 2) {
                return step;
            }
        }
        return 0;
    }

    /**
     * 求入环点
     * @param head
     * @return
     */
    public static int enterCycleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        ListNode meetingPoint = null;

        // 确认入环点
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                meetingPoint = p2;
                break;
            }
        }

        if (meetingPoint == null) {
            return -1;
        }

        // 确认入环点之后把p1指针重置到头指针，p2放在相遇点
        p1 = head;
        p2 = meetingPoint;

        // 然后按每次一步前推两个指针，直到相遇即为环点。
        while (true) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == p2) {
                return p1.val;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println(hasCycle(node1));

        System.out.println(cycleLen(node1));

        System.out.println(enterCycleNode(node1));
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}