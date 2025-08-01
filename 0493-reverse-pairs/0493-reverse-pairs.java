class Solution {
    public int reversePairs(int[] nums) {
        //naive solution
        //return naive(nums);
        return mergeSort(0,nums.length-1,nums);
    }

    public int naive(int[] arr){
        int cnt = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(i<j && arr[i]>2*arr[j])
                    cnt++;
            }
        }
        return cnt;
    }


    public int mergeSort(int l,int r,int[] nums){
        int count=0;
        if(l<r){
            int mid = (l+r)/2;
            count+=mergeSort(l,mid,nums);
            count+=mergeSort(mid+1,r,nums);
            count+=countPair(l,mid,r,nums);
            merge(l,mid,r,nums);
        }
        return count;
    }

    public int countPair(int l,int mid,int r,int arr[]){
        int j = mid+1;
        int cnt = 0;
        for(int i = l;i<=mid;i++){
            while(j<=r && (long)arr[i]>2L*arr[j])
                j++;
            cnt+=(j-(mid+1));
        }
        return cnt;
    }

    public void merge(int l,int mid,int r,int arr[]){
        int left = l;
        int right = mid+1;
        List<Integer> tem = new ArrayList<>();
        while(left<=mid && right<=r){
            if(arr[left]<=arr[right]){
                tem.add(arr[left]);
                left++;
            }
            else{
                tem.add(arr[right]);
                right++;
            }
            
        }
        while(left<=mid){
                tem.add(arr[left]);
                left++;
            }
            while(right<=r){
                tem.add(arr[right]);
                right++;
            }
            for(int i=l;i<=r;i++){
                arr[i] = tem.get(i-l);
            }
    }
}