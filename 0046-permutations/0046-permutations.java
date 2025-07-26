class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        permutation(0,nums,res);
        return res;
    }
     public static void permutation(int ind,int[] arr,List<List<Integer>> res)  {
        List<Integer> ds = new ArrayList<>();
        int n = arr.length;
        if(ind == n){
            for(int i=0;i<n;i++)
                ds.add(arr[i]);
            res.add(ds);
        }
        for(int i=ind;i<n;i++){
            swap(i,ind,arr);
            permutation(ind+1,arr,res);
            swap(i,ind,arr);
        }
    }
    public static void swap(int i,int ind,int[] arr){
        int tem = arr[i];
        arr[i] = arr[ind];
        arr[ind] = tem;
    }
}