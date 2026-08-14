/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
import java.util.*;
class Solution {
    public Node copyRandomList(Node head) {
        Node dum = new Node(-1);
        Node tem = dum;
        Node head1 = head;
        Map<Node,Node> map = new HashMap<>();

        while(head1!=null){
            Node newnode1 = new Node(head1.val);
            map.put(head1,newnode1);
            tem.next = newnode1;
            tem = tem.next;
            head1 = head1.next;
        }
        Node tem2 = dum.next;
        while(head!=null){
            if(head.random == null){
                tem2.random = null;
            }else{
                if(map.containsKey(head.random)){
                    tem2.random = map.get(head.random);
                }
            }
            head = head.next;
            tem2 = tem2.next;
        }

        return dum.next;
    }
}