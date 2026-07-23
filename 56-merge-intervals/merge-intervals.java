import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int prev[] = intervals[0];
        
        for(int i=1;i<intervals.length;i++){
            int val[] = intervals[i];
            if(val[0]<=prev[1]){
                prev[1] = Math.max(prev[1],val[1]);
            }else{
                List<Integer> sub = new ArrayList<>();
                sub.add(prev[0]);
                sub.add(prev[1]);
                res.add(sub);
                prev = intervals[i];
            }
        }
        List<Integer> sub = new ArrayList<>();
                sub.add(prev[0]);
                sub.add(prev[1]);
        res.add(sub);
        int n = res.size();
        int fin[][] = new int[n][2];
        for(int i=0;i<n;i++){
            fin[i][0] = res.get(i).get(0);
            fin[i][1] = res.get(i).get(1);
        } 
        return fin;         
    }
}