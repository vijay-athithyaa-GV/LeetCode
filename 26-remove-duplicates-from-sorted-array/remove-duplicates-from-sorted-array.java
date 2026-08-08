class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        int n =nums.length;
        int k = 0;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        k = set.size();
        int i = 0;
        for(int ele:set){
            if(i<k) nums[i] = ele;
            i++;
        } 
        return k;       
    }
}