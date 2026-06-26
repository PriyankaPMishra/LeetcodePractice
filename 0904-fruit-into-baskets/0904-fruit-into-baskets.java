class Solution {
    public int totalFruit(int[] fruits) {
        int res = 0;
        HashMap<Integer, Integer> basket = new HashMap<>();
        int left = 0, right = 0, n = fruits.length;
        while(left < n) {
            //put fruits into basket
            //if no fruits default value = 0 
            basket.put(fruits[left], basket.getOrDefault(fruits[left], 0)+1);

            //if basket size is more than 2 
            //remove fruits with count 1
            //else decrement the count value of fruit
            while(basket.size() > 2) {
                if(basket.get(fruits[right]) == 1)
                    basket.remove(fruits[right]);
                else 
                    basket.put(fruits[right], basket.get(fruits[right]) - 1);
                right++;
            }

            //count max of res and updated fruit value
            res = Math.max(res, left - right + 1);
            left++;
        } 
        
        return res;
    }
}