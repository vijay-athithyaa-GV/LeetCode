import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int freq[] = new int[128];
        Arrays.fill(freq,0);
        //placing the character count..
        for(char c:t.toCharArray()){
            freq[c]++;
        }  
        int cnt = 0;
        int minLeng = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int Starind = -1;
        while(r<n){
            if(freq[s.charAt(r)]>0){
                cnt++;
            }
            freq[s.charAt(r)]--;
            while(cnt == m){
                if(r-l+1 < minLeng){
                    minLeng = r-l+1;
                    Starind = l;
                }
                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)]>0) cnt--;
                l++;
            }
            r++;
        }
        return  Starind==-1?"":s.substring(Starind,Starind+minLeng);
    }
}