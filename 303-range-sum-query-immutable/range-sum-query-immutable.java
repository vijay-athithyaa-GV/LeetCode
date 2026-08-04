class NumArray {
    int res[];
    public NumArray(int[] nums) {
        int n = nums.length;
        res = nums.clone();
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i=left;i<=right;i++){
            sum+=res[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */