class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String rev_s = new StringBuilder(s).reverse().toString();
        String new_s = s + "*" + rev_s;

        int[] lps = new int[new_s.length()];

        for (int i = 1; i < new_s.length(); i++) {
            
            int j = lps[i - 1];
            while (j > 0 && new_s.charAt(i) != new_s.charAt(j)) {
                j = lps[j - 1];
            }
            if (new_s.charAt(i) == new_s.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }
        int max_palindrome_len = lps[lps.length - 1];
        String to_add = rev_s.substring(0, s.length() - max_palindrome_len);
        return to_add + s;
    }
}
