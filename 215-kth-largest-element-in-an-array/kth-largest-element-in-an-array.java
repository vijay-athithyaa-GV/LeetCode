import java.util.*;

class Solution {
    Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;  // kth largest -> kth smallest
        return quickSelect(nums, 0, n - 1, k);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[l];

        // randomize pivot
        int pivotIndex = l + rand.nextInt(r - l + 1);
        int pivot = nums[pivotIndex];

        // 3-way partition
        int lt = l, i = l, gt = r;
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt, i);
                lt++;
                i++;
            } else if (nums[i] > pivot) {
                swap(nums, i, gt);
                gt--;
            } else {
                i++;
            }
        }

        // now: [l..lt-1] < pivot, [lt..gt] == pivot, [gt+1..r] > pivot

        if (k >= lt && k <= gt) return nums[k];
        else if (k < lt) return quickSelect(nums, l, lt - 1, k);
        else return quickSelect(nums, gt + 1, r, k);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
