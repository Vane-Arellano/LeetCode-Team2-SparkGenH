
public class Main
{
	public static String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String rev_s = new StringBuilder(s).reverse().toString();
        // we concatenate the original string plus a * separator to the reversed string so we can apply KMP algorithm
        String new_s = s + "*" + rev_s;

        // We create the longest palindrome suffix array 
        int[] lps = new int[new_s.length()];

        for (int i = 1; i < new_s.length(); i++) {
            //for each char of the new string created, we compare the character on the ith position 
            // to the pasts chars represented by the jth position, if this are equal, we increment j on one 
            // if this are not equal, we place j the value of the length of the last maximum palindrome
            // we set on the ith element of lps the value of j that at this point represents the length of the maximum palindrome 
            int j = lps[i - 1];
            while (j > 0 && new_s.charAt(i) != new_s.charAt(j)) {
                j = lps[j - 1];
            }
            if (new_s.charAt(i) == new_s.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        // the last element of the lps array has the length of the max palindrome within the original string 
        int max_palindrome_len = lps[lps.length - 1];

        // here we get the remaining last characters of the original 
        //string by taking out the ones containing the palindrome
        String to_add = rev_s.substring(0, s.length() - max_palindrome_len);
        System.out.println(to_add + s);
        return to_add + s;
    }
	public static void main(String[] args) {
	    String s = "aacecaaa";
        shortestPalindrome(s);
    }
}

