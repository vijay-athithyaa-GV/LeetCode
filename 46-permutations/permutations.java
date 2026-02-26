class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        arrpermutate(0,nums,ans,n);
        return ans;

    }

    public void arrpermutate(int ind,int[] nums,List<List<Integer>> ans,int n){
        if(ind == n){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<n;i++){
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }
        for(int i=ind;i<n;i++){
            swap(i,ind,nums);
            arrpermutate(ind+1,nums,ans,n);
            swap(i,ind,nums);
        }
    }
    public void swap(int i,int j,int[] nums){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}