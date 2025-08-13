import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        subset(0,nums,ds,res);
        return res;
    }

    public void subset(int ind,int arr[],List<Integer> ds,List<List<Integer>> res){
        res.add(new ArrayList<>(ds));
        for(int i=ind;i<arr.length;i++){
            if(i!=ind && arr[i] == arr[i-1]) continue;
            ds.add(arr[i]);
            subset(i+1,arr,ds,res);
            ds.remove(ds.size()-1);
        }
    }
}