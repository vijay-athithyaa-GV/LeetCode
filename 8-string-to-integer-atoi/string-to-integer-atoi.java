class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int sign = 1;
        int res=0;
        while(i<n && s.charAt(i)==' ') i++;
        if(i<n && (s.charAt(i)=='-'||s.charAt(i)=='+')){
            sign = (s.charAt(i)=='-')?-1:1;
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))){
            int digi = s.charAt(i)-'0';
            if(res>(Integer.MAX_VALUE-digi)/10){
                return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res*10+s.charAt(i)-'0';
            i++;
        }
        return res*sign;
    }
}