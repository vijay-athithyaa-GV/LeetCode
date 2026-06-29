import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int prev[] = intervals[0];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=prev[1]){
                prev[1] = Math.max(prev[1],intervals[i][1]);
            }
            else{
                res.add(prev);
                prev = intervals[i];
            }
        }
        res.add(prev);
        int sol[][] = res.toArray(new int[res.size()][]);
        return sol;
    }
}