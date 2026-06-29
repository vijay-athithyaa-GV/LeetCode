import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        // List<int[]> tem = new ArrayList<>();
        // // for(int i=0;i<n;i++){
        // //     int sub[]={intervals[i][0],intervals[i][1]};
        // //     tem.add(sub);
        // // }
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