import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0;i<n;i++){
            Set<Integer> s = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int tem = -(nums[i]+nums[j]);
                if(s.contains(tem)){
                    List<Integer> lt = new ArrayList<>();
                    lt.add(nums[i]);
                    lt.add(nums[j]);
                    lt.add(tem);
                    Collections.sort(lt);
                    st.add(lt);
                }
                s.add(nums[j]);
            }
        }
        List<List<Integer>> res = new ArrayList<>(st);
        return res;
    }
}