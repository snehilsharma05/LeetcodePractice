class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0,mid = 0,high = n-1;
        int temp;
        while(mid <= high){
            switch(nums[mid]){
                case 0:
                    temp = nums[mid];
                    nums[mid] = nums[low];
                    nums[low] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = nums[high];
                    nums[high] = nums[mid];
                    nums[mid] = temp;
                    high--;
                    break;
            }
        }
    }
}