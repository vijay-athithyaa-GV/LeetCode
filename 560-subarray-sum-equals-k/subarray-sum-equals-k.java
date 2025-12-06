class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int csum = 0;
        Map<Integer,Integer> map= new HashMap<>();
        int tot=0;
        map.put(0,1);

        for(int i=0;i<n;i++){
            csum+=nums[i]; 
            if(map.containsKey(csum-k)){
                tot+=map.get(csum-k);
            }
            map.put(csum,map.getOrDefault(csum,0)+1);
        }
        return tot;
    }
}