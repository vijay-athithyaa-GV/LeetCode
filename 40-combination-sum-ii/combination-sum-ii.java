import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(candidates);
        comb(0,candidates,sub,target,res);
        List<List<Integer>> res1 = new ArrayList<>(res);
        return res1;
    }

    public void comb(int ind,int arr[],List<Integer> sub,int tar,List<List<Integer>> res){
        int n = arr.length;
        if(tar == 0){
            res.add(new ArrayList<>(sub));
            return;
        }
        for(int i=ind;i<n;i++){
            if(i>ind && arr[i]==arr[i-1])
                continue; 
            if(arr[i]<=tar){
                sub.add(arr[i]);
                comb(i+1,arr,sub,tar-arr[i],res);
                sub.remove(sub.size()-1);
            }
        }
    }
}