class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] > max) max = nums[i];
            if(nums[i] < min) min = nums[i];
        }
        return gcd(min, max);
    }
    private int gcd(int x, int y){
        if (x%y == 0) return y;
        else return gcd(y, x%y);
    }
}