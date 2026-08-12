import java.util.*;

class Pair{
    int ele,min;
    Pair(int ele,int min){
        this.ele = ele;
        this.min = min;
    }
}

class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {
        int topmin = value;
        if(!st.isEmpty()){
            topmin = Math.min(value,st.peek().min);
        }
        Pair p = new Pair(value,topmin);
        st.push(p);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().ele;
    }
    
    public int getMin() {
       return st.peek().min;
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