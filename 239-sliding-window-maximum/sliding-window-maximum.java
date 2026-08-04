import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                res.add(dq.peekFirst());
            }
        }
        int size = res.size();
        int ress[] = new int[size];
        for(int i=0;i<size;i++){
            ress[i] = nums[res.get(i)];
        }
        return ress;
    }
}