import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int elem1 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;
        int elem2 = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            if(cnt1 == 0 && elem2!=nums[i]){
                elem1 = nums[i];
                cnt1++;
            }else if(cnt2 == 0 && elem1!=nums[i]){
                elem2 = nums[i];
                cnt2++;
            }else if(elem1 == nums[i]){cnt1++;}
            else if(elem2 == nums[i]){cnt2++;}
            else{
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == elem1) cnt1++;
            if(nums[i] == elem2) cnt2++;
        }

        if(cnt1 >=(n/3)+1) res.add(elem1);
        if(cnt2 >=(n/3)+1) res.add(elem2);

        return res;
    }
}