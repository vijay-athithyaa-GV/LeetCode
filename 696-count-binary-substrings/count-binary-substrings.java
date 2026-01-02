import java.util.*;

class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> temp = new ArrayList<>();
        int sum = 1;
        int n = s.length();
        for(int i=1;i<n;i++){
            if(s.charAt(i-1) == s.charAt(i)){
                sum++;
            }
            else{
                temp.add(sum);
                sum = 1;
            }
        }
        temp.add(sum);
        //solution part
        int m = temp.size();
        int res = 0;
        for(int i=1;i<m;i++){
            res += Math.min(temp.get(i-1),temp.get(i));
        }
    return res;
    }
}