class Solution:
    def shortestPalindrome(self, s):
        accum = ""
        index = -1

        if s == s[::-1]:
            return s
        
        while index != (len(s)*-1):
            accum = accum + s[index]
            
            if accum + s == (accum+s)[::-1]:
                return accum + s

            index -= 1

        return acumm + s
