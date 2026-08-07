import java.util.*;

class Pair{
    int price,span;
    Pair(int price,int span){
        this.price = price;
        this.span = span;
    }
}

class StockSpanner {
    Deque<Pair> dq;
    public StockSpanner() {
        dq = new ArrayDeque<>();
    }
    public int next(int price) {
        int span = 1;
        while(!dq.isEmpty() && dq.peekFirst().price<=price){
            span += dq.peekFirst().span;
            dq.pollFirst();
        }
        dq.addFirst(new Pair(price,span));
        return span;
    }
    //daily collect -> return the span of stock at the current Day.
        //need to check what is being repeating..

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */