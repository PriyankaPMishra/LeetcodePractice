class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            //to prevent 1st duplicate
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                //nums[i] -> fixed number in each iteration
                //nums[left] -> lower bound
                //nums[right] -> upper bound
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //move pointers for next triplet creation
                    left++; 
                    right--;

                    //to prevent 2nd duplicate
                    while ((left < right) && (nums[left] == nums[left - 1])) {
                        left++;
                    }

                    //to prevent 3rd duplicate
                    while ((left < right) && (nums[right] == nums[right + 1])) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}