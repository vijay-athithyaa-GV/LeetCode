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
    public void reorderList(ListNode head) {
        //need to find the mid first
        //need to reverse the sub from the mid
        //need to alternatively append

        if(head==null || head.next==null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        //Reverse process...
        ListNode prev = null;
        while(curr!=null){
            ListNode newnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newnode;
        }

        ListNode first = head;
        ListNode second = prev;

        while(second!=null){
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;
            first = t1;
            second = t2;
        }
    }
}