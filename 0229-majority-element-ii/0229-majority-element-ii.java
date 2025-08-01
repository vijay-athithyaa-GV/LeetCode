class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(res.size() == 0 || res.get(0)!=nums[i]){
                cnt = 0;
                for(int j=0;j<n;j++){
                    if(nums[i]==nums[j])
                        cnt++;
                }
                if(cnt>n/3)
                    res.add(nums[i]);
            }
            if(res.size()==2)
                break;
        }
        return res;
    }
}