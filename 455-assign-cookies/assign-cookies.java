import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int cnt = 0;
        int i=0,j=0;
        int n = g.length;
        int m = s.length;
        while(i<n && j<m){
            if(s[j]>=g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}