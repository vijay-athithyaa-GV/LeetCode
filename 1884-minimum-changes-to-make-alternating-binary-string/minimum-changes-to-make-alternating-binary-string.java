class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i=0;i<n;i++){
            char exp1= (i%2==0)?'0':'1';
            char exp2= (i%2==0)?'1':'0';
            if(exp1 != s.charAt(i)) cnt1++;
            if(exp2 != s.charAt(i)) cnt2++;
        } 
        return Math.min(cnt1,cnt2);
    }
}