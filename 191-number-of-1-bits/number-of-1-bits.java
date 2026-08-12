class Solution {
    public int hammingWeight(int n) {
        int tem = n;
        int cnt = 0;
        for(int i=0;i<32;i++){
            if(((tem>>i) & 1)==1) cnt++;
        }
        return cnt;
    }
}