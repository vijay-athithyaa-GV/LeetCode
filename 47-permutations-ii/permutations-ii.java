import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ans= new HashSet<>();
        List<Integer> ds = new ArrayList<>();
        boolean flag[] = new boolean[n];
        Arrays.fill(flag,false);
        permutate(nums,n,ds,ans,flag);
        List<List<Integer>> res = new ArrayList<>(ans);
        return res;
    }
    public void permutate(int arr[],int n,List<Integer> ds,Set<List<Integer>> ans,boolean[]flag){
        if(ds.size()==n){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<n;i++){
            if(!flag[i]){
                flag[i] = true;
                ds.add(arr[i]);
                permutate(arr,n,ds,ans,flag);
                ds.remove(ds.size()-1);
                flag[i] = false;
            }
        }
    }
}