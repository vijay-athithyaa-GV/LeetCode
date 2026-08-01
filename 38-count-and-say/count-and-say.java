import java.util.*;

class Solution {
    public String countAndSay(int n) {
        String res = "1";
        if(n == 1) return res;
        for(int i=0;i<n-1;i++){
            res = find(res);
            System.out.println(res);
        }
        return res;
    }

    public String find(String res){
        StringBuilder las = new StringBuilder();
        int i = 0;
        int j = 0;
        while(j<res.length()){
            char c = res.charAt(i);
            j = i+1;
            int cnt = 1;
            while(j<res.length() && c==res.charAt(j)){
                cnt++;
                j++;
            }
            las.append(String.valueOf(cnt));
            las.append(String.valueOf(c));
            i = j;
        }
        return las.toString();
    }
}