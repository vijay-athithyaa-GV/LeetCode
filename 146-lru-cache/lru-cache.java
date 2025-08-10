import java.util.*;

class ListNode{
    int val;
    int key;
    ListNode pre;
    ListNode next;
    ListNode(int key,int val){
        this.val = val;
        this.key = key;
        pre = null;
        next= null;
    }
}

class LRUCache {
    ListNode head = new ListNode(-1,-1);
    ListNode tail = new ListNode(-1,-1);
    int size =0;
    Map<Integer,ListNode> cache = new HashMap<>();

    public void insertAtHead(ListNode node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public void deleteNode(ListNode node){
        ListNode prenode = node.pre;
        ListNode afternode = node.next;
        prenode.next = afternode;
        afternode.pre = prenode;
    }


    public LRUCache(int capacity) {
        this.size = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
       if(cache.containsKey(key)){
            ListNode node = cache.get(key);
            deleteNode(node);
            insertAtHead(node);
            return node.val;
       }
       return -1;
    }

    
    public void put(int key, int value) {
        
        if(cache.containsKey(key)){
            ListNode node = cache.get(key);
            node.val = value;
            cache.put(key,node);
            deleteNode(node);
            insertAtHead(node);  
       }else{
            ListNode newnode = new ListNode(key,value);
            if(cache.size() == size){
                ListNode node = tail.pre;
                cache.remove(node.key);
                deleteNode(node);
            }
            insertAtHead(newnode);
            cache.put(key,newnode);
       }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */