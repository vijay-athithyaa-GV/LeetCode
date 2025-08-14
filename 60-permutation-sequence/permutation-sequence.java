import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        k = k-1;
        String res = "";
        List<Integer> tem = new ArrayList<>();
        for(int i=1;i<n;i++){
            fact = fact*i;
            tem.add(i);
        }
        tem.add(n);

        while(true){
            res = res + tem.get(k/fact);
            tem.remove(k/fact);
            if(tem.size() == 0){
                break;
            }

            k = k%fact;
            fact = fact/tem.size();
        }
        return res;
    }
}