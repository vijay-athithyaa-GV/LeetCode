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
        int n = 0;
        ListNode tem = head;
        ListNode tem1 = head;
        while(tem!=null){
            tem = tem.next;
            n++;
        }
        for(int i=0;i<n/2;i++){
            tem1 = tem1.next;
        }
        return tem1;
    }
}