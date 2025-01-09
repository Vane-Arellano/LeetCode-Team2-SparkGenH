class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int[] left = new int[days]; int[] right = new int[days]; 
        int left_min = prices[0];
        int right_max = prices[days-1];
        int profit = right[0];

        if(days == 1){
            return profit;
        }

        left[0] = 0; 
        right[days-1] = 0;

        for(int i=1; i<days; i++){
            left[i] = Math.max(left[i-1], prices[i] - left_min); 
            left_min = Math.min(left_min, prices[i]);
        }
        for(int i = days-2; i >= 0; i--){
            right[i] = Math.max(right[i+1], right_max - prices[i]); 
            right_max = Math.max(right_max, prices[i]);
        }
        
        profit = right[0];
        for(int i = 1; i < days-1; i++){
            profit = Math.max(profit, left[i-1]+right[i]);
        }

        return profit;
    
    
    }
}
