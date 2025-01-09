class Solution:
    def minPatches(self, nums, n):
        index = changes = 0 
        comp = 1 

        while comp <= n:
            if index < len(nums) and nums[index] <= comp:
                comp += nums[index]
                index += 1
            else:
                comp += comp
                changes += 1

        return changes
