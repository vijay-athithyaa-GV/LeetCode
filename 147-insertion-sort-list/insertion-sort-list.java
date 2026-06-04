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
import java.util.*;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode temp = head;
        List<Integer> res = new ArrayList<>();
        while(temp!=null){
            res.add(temp.val);
            temp = temp.next;
        }    
        // int res[] = new int[n];
        // temp = head;
        // int i = 0;
        // while(temp!=null){
        //     res[i++] = temp.val;
        //     temp = temp.next;
        // } 
        //insertSort(res,n);
        int n = res.size();
        Collections.sort(res);
        ListNode reslist = new ListNode(-1);
        ListNode curr = reslist;
        for(int j=0;j<n;j++){
            ListNode newnode = new ListNode(res.get(j));
            curr.next = newnode;
            curr = curr.next;
        }
        return reslist.next;
    }

    public void insertSort(int res[],int n){
        for(int i=1;i<n;i++){
            int tem = res[i];
            int j = i-1;
            while(j>=0 && res[j]>tem){
                res[j+1] = res[j];
                j--;
            }
            res[j+1] = tem;
        }
    }
}