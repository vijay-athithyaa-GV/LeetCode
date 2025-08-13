import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        comsum(0,target,new ArrayList<>(),res,candidates);
        return res;
    }
    public void comsum(int ind,int tar,List<Integer> ds,List<List<Integer>> res,int[] can){
        if(tar == 0){
            res.add(new ArrayList<>(ds));
            return;
        } 
        for(int i=ind;i<can.length;i++){
            if(i>ind && can[i-1] == can[i]) continue;
            if(tar<can[i]) break;
            ds.add(can[i]);
            comsum(i+1,tar-can[i],ds,res,can);
            ds.remove(ds.size()-1);
        }
    }
}