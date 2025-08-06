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
    public ListNode middleNode(ListNode head) {
        ListNode tem = head;
        int n=0;
        while(tem!=null){
            tem = tem.next;
            n++;
        }
        n = (n/2)+1;
        ListNode res = head;
        int i=1;
        while(i<n){
            res = res.next;
            i++;
        }
        return res;
    }
}