// selection sort
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
     for(int i = 1; i < n; i++) {
         int temp = nums[i], j = i-1;
         while(j >= 0 && temp < nums[j]) {
             nums[j+1] = nums[j];
             j--;
         }
         nums[j + 1] = temp;
     }
        return nums;
    }
}
