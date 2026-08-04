class NumArray {
    int res[];
    public NumArray(int[] nums) {
        res = nums.clone();
        for(int i=1;i<nums.length;i++){
            res[i] += res[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return res[right];
        return res[right]-res[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */