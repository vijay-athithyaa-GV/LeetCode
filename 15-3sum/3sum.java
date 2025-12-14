class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res;
        for(int i=0;i<n;i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j=i+1;j<n;j++){
                List<Integer> sub = new ArrayList<>();
                int k = -(nums[i]+nums[j]);
                if(map.containsKey(k)){
                    sub.add(nums[i]);
                    sub.add(nums[j]);
                    sub.add(k);
                    Collections.sort(sub);
                    set.add(sub);                    
                }
                map.put(nums[j],1);
            }
        }
        res = new ArrayList<>(set);
        return res;
    }
}