
/*
给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class Exercise3 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head==null){
                return null;
            }
            if(head.next==null||head.next.next==null){
                return head;
            }
            ListNode p=head;
            ListNode q=head.next;
            while(q!=null){
                ListNode cur=p.next;
                if(q.next==null){

                    return head;
                }
                ListNode node=q.next.next;
                p.next=q.next;
                q.next=node;
                p.next.next=cur;
                p=p.next;
                q=q.next;
            }
            return head;
        }
    }
}
