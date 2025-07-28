import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        int N = intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<List<Integer>> res = interval(intervals,N);
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i).get(0);
            result[i][1] = res.get(i).get(1);
        }
        return result;
    }
    public List<List<Integer>> interval(int[][]arr,int n){
        List<List<Integer>> res = new ArrayList<>();
      
        for(int i=0;i<n;i++){
            int start = arr[i][0];
            int end = arr[i][1];
            if(!res.isEmpty() && end<=res.get(res.size()-1).get(1)){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(arr[j][0]<=end){
                    end = Math.max(end,arr[j][1]);
                }
                else
                    break; 
            }
            res.add(Arrays.asList(start,end));
        }
        return res;
    }
}