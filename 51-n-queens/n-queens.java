import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        for(int i=0;i<n;i++){
            ds.add(".".repeat(n));
        }
        Queen(0,ds,res,n);
        return res;
    }

    public void Queen(int col, List<String> ds,List<List<String>> res,int n){
        //base condition..
        if(col == n){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<n;i++){
            if(NotAttacked(i,col,ds,n)){
                String s = ds.get(i);
                StringBuilder s1 = new StringBuilder(s);
                s1.setCharAt(col,'Q');
                String tem = s1.toString();
                ds.set(i,tem);

                Queen(col+1,ds,res,n);

                StringBuilder s2 = new StringBuilder(tem);
                s2.setCharAt(col,'.');
                ds.set(i,s2.toString());
            }
        }
    }

    public boolean NotAttacked(int row,int col,List<String> ds,int n){
        boolean flg = true;
        int c1 = col;
        int r1 = row;
        while(c1>=0){
            String s = ds.get(r1);
            if(s.charAt(c1) == 'Q'){
                return false;
            }
            c1--;
        }
        //top diagonal..
        int c2 = col;
        int r2 = row;
        while(c2>=0 && r2>=0){
            String s = ds.get(r2);
            if(s.charAt(c2) == 'Q'){
                return false;
            }
            c2--;
            r2--;
        }

        int c3 = col;
        int r3 = row;
        while(c3>=0 && r3<n){
            String s = ds.get(r3);
            if(s.charAt(c3) == 'Q'){
                return false;
            }
            c3--;
            r3++;
        }
        return flg;
    }
}