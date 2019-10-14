/*
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。
 */
 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }


    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode cur = head;
            ListNode node = null;

            while (cur != null) {
                ListNode q = node;
                if (cur.val < x) {
                    ListNode p = new ListNode(cur.val);
                    if (node == null) {
                        node = p;
                    } else {
                        while (q.next != null) {
                            q = q.next;
                        }
                        q.next = p;
                    }
                }
                cur = cur.next;

            }
            cur = head;
            while (cur != null) {
                ListNode q = node;
                if (cur.val >= x) {
                    ListNode p = new ListNode(cur.val);
                    if (node == null) {
                        node = p;
                    } else {
                        while (q.next != null) {
                            q = q.next;
                        }
                        q.next = p;
                    }
                }
                cur = cur.next;
            }
            return node;
        }
    }
}