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
    public boolean isPalindrome(ListNode head) {
        if(head==null ||head.next==null)
            return true;
        ListNode s = head;
        ListNode f = head;
        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
        }
        ListNode mid = s;
        ListNode newHead = null;
        while(mid!=null){
            ListNode next = mid.next;
            mid.next = newHead;
            newHead = mid;
            mid = next;
        }
        ListNode dum = head;
        ListNode tem = newHead;
        while(tem!=null){
            if(dum.val !=tem.val) return false;
                dum = dum.next;
                tem = tem.next;
            }
        return true;
    }
}