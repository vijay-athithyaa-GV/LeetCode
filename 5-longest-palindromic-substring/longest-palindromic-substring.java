import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int ml = -1;//represents the string position index..
        int mr = -1;
        int max = -1;
        for(int i=0;i<n;i++){
            int l = i,r = i;
            //odd length palindrome..
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>=max){
                    ml = l;
                    mr = r;
                    max = r-l+1;
                }
                l--;
                r++;
            }
            //even length palindrome..
            l = i;
            r = i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>=max){
                    ml = l;
                    mr = r;
                    max = r-l+1;
                }
                l--;
                r++;
            }
        }
        return s.substring(ml,mr+1);
    }
}