class Solution {
    public int trap(int[] height) {
        return optimal(height);
    }
    public int better(int[] height){
        int n = height.length;
        int prefix[] = new int[n];
        prefix[0] = height[0];
        for(int i=1;i<n;i++){
            prefix[i] = Math.max(prefix[i-1],height[i]);
        }
        int suffix[] = new int[n];
        suffix[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i] = Math.max(suffix[i+1],height[i]);
        }
        int total = 0;
        for(int i=0;i<n;i++){
            int leftmax = prefix[i];
            int rightmax = suffix[i];
            if(height[i]<leftmax && height[i]<rightmax){
                total+=Math.min(leftmax,rightmax)-height[i];
            }
        }
        return total;
    }

    public int optimal(int[] height){
        int n = height.length;
        int lmax = 0;
        int rmax = 0;
        int total = 0;
        int l = 0;
        int r = n-1;
        while(l<r){
            if(height[l]<=height[r]){
                if(lmax>height[l])
                    total+=lmax - height[l];
                else
                    lmax = height[l];
                l++;
            }
            else{
                if(rmax>height[r])
                    total+=rmax - height[r];
                else
                    rmax = height[r];
                r--;
            }
        }
        return  total;
    }
}