class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int psum = 0;
        for(int i=0;i<n;i++){
            psum+=nums[i];
            if(map.containsKey(psum-k)){
                cnt+=map.get(psum-k);
            }
            if(map.containsKey(psum)){
                map.put(psum,map.get(psum)+1);
            }
            else
                map.put(psum,1);

        }
        return cnt;
    }
}