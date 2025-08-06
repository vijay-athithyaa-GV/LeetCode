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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tem = head;
        int count=0,i=0;
        while(tem!=null){
            tem=tem.next;
            count++;
        }
        n = count-n;
        ListNode tem1 = dummy;
        while(i<n){
           tem1 = tem1.next;
           i++;
        }
        tem1.next = tem1.next.next;
        return dummy.next;
    }
    
}