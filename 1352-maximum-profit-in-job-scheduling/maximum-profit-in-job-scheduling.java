import java.util.*;

class triple{
    int start;
    int end;
    int wt;
    triple(int start,int end,int wt){
        this.start = start;
        this.end = end;
        this.wt = wt;
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // //choosing the max profit
        // //seems like the overlapping problem
        int n = startTime.length;
        List<triple> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new triple(startTime[i],endTime[i],profit[i]));
        }
        arr.sort((a,b)->Integer.compare(a.start,b.start));
        // // logic execution..
        int dp[] = new int[n]; 
        Arrays.fill(dp,-1);

    //solving the problem using the LCS->Binary search
        
        return find1(0,arr,dp);
    }

    public int find1(int ind,List<triple>arr,int[] dp){
        if(ind >= arr.size()||ind == -1) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int not = find1(ind+1,arr,dp);
        int next = lb(arr,ind,arr.size()-1,arr.get(ind).end);
        int take = arr.get(ind).wt + find1(next,arr,dp);
        return dp[ind] = Math.max(not,take);
    }


    public int find(int curr,int prev,List<triple> arr,int[][]dp){
        if(curr == arr.size()) return 0;
        if(dp[curr][prev+1]!=-1) return dp[curr][prev+1];
        int take = Integer.MIN_VALUE;
        if(prev == -1||arr.get(curr).start>=arr.get(prev).end){
            take = arr.get(curr).wt + find(curr+1,curr,arr,dp);
        }
        int not = find(curr+1,prev,arr,dp);
        return dp[curr][prev+1] = Math.max(take,not);
    }

    public int lb(List<triple> ls,int start,int end,int x){//x contains the end time..
        int tem = -1;
        while(start<=end){
            int mid = (start+end)/2;
            if(ls.get(mid).start>=x){
                tem = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return tem;
    }
}