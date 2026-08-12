class Solution {
    public int hammingWeight(int n) {
        String res = "";
        int tem = n;
        while(tem>1){
            int q = tem/2;
            int r = tem%2;
            res = res+String.valueOf(r);
            System.out.println(res);
            tem = q;
        }   
        res = res+String.valueOf(tem);
        int cnt = 0;
        for(char c:res.toCharArray()){
            if(c == '1') cnt++;
        }
        return cnt;
    }
}