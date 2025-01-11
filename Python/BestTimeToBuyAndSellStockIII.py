class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        First_Buy = float("-inf")
        First_Sell = 0
        Second_Buy = float("-inf")
        Second_Sell = 0

        for price in prices:
            First_Buy = max(First_Buy, -price)
            First_Sell = max(First_Sell, First_Buy + price)

            Second_Buy = max(Second_Buy, First_Sell - price)
            Second_Sell = max(Second_Sell, Second_Buy + price)

        return Second_Sell
