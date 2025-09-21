import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        List<Map.Entry<Integer,Integer>> entryset = new ArrayList<>(map.entrySet());
        entryset.sort((a,b)->b.getValue()-a.getValue());
        int res[] = new int[k];
        for(int i=0;i<k;i++){
            res[i] = entryset.get(i).getKey();
        }
        return res;

    }
}