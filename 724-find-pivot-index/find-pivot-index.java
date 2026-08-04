class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int res1[] = nums.clone();
        int res2[] = nums.clone();

        for(int i=1;i<n;i++){
            res1[i]+=res1[i-1];
        }
        for(int i=n-2;i>=0;i--){
            res2[i]+=res2[i+1];
        } 
        for(int i=0;i<n;i++){
            if(res1[i] == res2[i]) return i;
        }    
        return -1;         
    }
}