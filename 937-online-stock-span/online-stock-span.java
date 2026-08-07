import java.util.*;

class StockSpanner {
    List<Integer> list;
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        int cnt = 1;
        for(int i=list.size()-1;i>=0;i--){
            int ele = list.get(i);
            if(ele<=price) cnt++;
            else break;
        }
        list.add(price);
        return cnt;
    }
    //daily collect -> return the span of stock at the current Day.

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */