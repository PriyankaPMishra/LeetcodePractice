class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        //initialise with 1st possible triplet
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                //if current sum is closer to target than previous closest, update closest
                if (Math.abs(target - sum) < Math.abs(target - closest)) 
                    closest = sum;

                //if exact macth found, cant get any closer
                if (sum == target) 
                    return sum;
                
                //sum too small, move to bigger numbers
                else if (sum < target) 
                    left++;
                
                //sum too large, move to smaller numbers
                else 
                    right--;
            }
        }
        return closest;
    }
}