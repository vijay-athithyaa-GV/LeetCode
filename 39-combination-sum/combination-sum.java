import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> sub = new ArrayList<>();
        comb(0,candidates,sub,target,res);
        List<List<Integer>> res1 = new ArrayList<>(res);
        return res1;
    }

    public void comb(int ind,int arr[],List<Integer> sub,int tar,Set<List<Integer>> res){
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