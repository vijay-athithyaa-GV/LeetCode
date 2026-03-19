import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        comb(0,candidates,sub,target,res);
        return res;
    }

    public void comb(int ind,int arr[],List<Integer> sub,int tar,List<List<Integer>> res){
        int n = arr.length;
        if(ind == n-1){
            if(tar == 0){
                res.add(new ArrayList<>(sub));
            }
            if(arr[ind]<=tar){
                sub.add(arr[ind]);
                comb(ind,arr,sub,tar-arr[ind],res);
                sub.remove(sub.size()-1); 
            }
            return;
        }
        if(arr[ind]<=tar){
            sub.add(arr[ind]);
            comb(ind,arr,sub,tar-arr[ind],res);
            sub.remove(sub.size()-1);
        }
        comb(ind+1,arr,sub,tar,res);
    } 
}