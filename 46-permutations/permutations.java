import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean flag[] = new boolean[n];
        Arrays.fill(flag,false);
        permutate(nums,n,ds,ans,flag);
        return ans;
    }
    public void permutate(int arr[],int n,List<Integer> ds,List<List<Integer>> ans,boolean[]flag){
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