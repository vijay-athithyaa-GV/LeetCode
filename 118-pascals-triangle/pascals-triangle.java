import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int n = numRows;
        //System.out.println(ncr(4,2));
        for(int row=1;row<=numRows;row++){
            List<Integer> sub = new ArrayList<>();
            for(int col=1;col<=row;col++){
                sub.add(ncr(row-1,col-1));
            }
            res.add(sub);
        }
        return res;
    }

    public int ncr(int N,int R){// like the nCr..
        R = Math.min(R,N-R);
        int res = 1;
        for(int i=0;i<R;i++){
            res = res*(N-i)/(i+1);
        }
        return res;
    }
}