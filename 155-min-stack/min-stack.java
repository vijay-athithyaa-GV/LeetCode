import java.util.*;

class MinStack {
    Stack<Integer> st;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {
        min=Math.min(min,value);
        st.push(value);
    }
    
    public void pop() {
        int val = st.pop();
        if(min == val){
            min = Integer.MAX_VALUE;
            for(int x:st){min = Math.min(min,x);}
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
       return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */