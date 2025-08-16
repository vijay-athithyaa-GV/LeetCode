import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        int left[] = new int[n];
        int leftupper[] = new int[2*n-1];
        int leftlower[] = new int[2*n-1];
        Arrays.fill(left,0);
        Arrays.fill(leftupper,0);
        Arrays.fill(leftlower,0);

        for(int i=0;i<n;i++){
            ds.add(".".repeat(n));
        }
        Queen(0,ds,res,n,left,leftupper,leftlower);
        return res;
    }

    public void Queen(int col, List<String> ds,List<List<String>> res,int n,int left[],int leftupper[],int leftlower[]){
        //base condition..
        if(col == n){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<n;i++){
        if(left[i] == 0 && leftupper[(n-1)+(col-i)]==0 && leftlower[col+i] == 0){
                String s = ds.get(i);
                StringBuilder s1 = new StringBuilder(s);
                s1.setCharAt(col,'Q');
                ds.set(i,s1.toString());
                left[i] = 1;
                leftupper[(n-1)+(col-i)] = 1;
                leftlower[col+i] = 1;

                Queen(col+1,ds,res,n,left,leftupper,leftlower);

                s1.setCharAt(col,'.');
                ds.set(i,s1.toString());
                left[i] = 0;
                leftupper[(n-1)+(col-i)] = 0;
                leftlower[col+i] = 0;
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
        c1 = col;
        r1 = row;
        while(c1>=0 && r1>=0){
            String s = ds.get(r1);
            if(s.charAt(c1) == 'Q'){
                return false;
            }
            c1--;
            r1--;
        }

        c1 = col;
        r1 = row;
        while(c1>=0 && r1<n){
            String s = ds.get(r1);
            if(s.charAt(c1) == 'Q'){
                return false;
            }
            c1--;
            r1++;
        }
        return flg;
    }
}