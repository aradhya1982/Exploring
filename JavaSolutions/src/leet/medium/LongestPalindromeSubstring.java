package leet.medium;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * given string S
 *     generate S' by inserting a bugus character ('|') between each character in S (including outer boundaries)
 *     Create array P to store the lengths of the palindrome for each center point in S (initally all 0s)
 *         (S'.length = P.length = 2*S.length+1)
 *     track the following pointers (referencing indices in P and S'):
 *         R -> the next element to be examined (initially 0)
 *         C -> the largest/left-most palindrome whose right boundary is R-1 (initially 0)
 *         i -> the next palindrome to be calculated (initially 1)
 *         L -> character candidate for comparing with R.  Computed implicitly as:
 *             L = i - (R - i)
 *         i' -> the palindrome mirroring i from C.  Computed implicitly as:
 *             i' = C - (i - C)
 *
 *     while R < P.length:
 *         If i is within the palindrome at C (Cases 1 and 2):
 *             Set P[i] = P[i'] (else P[i] is set to 0)
 *
 *         Expand the palindrome at i
 *          (primarily Cases 2 and 3; can be skipped in Case 1,
 *              though we have already shown that S'[R] != S'[L] because otherwise the palindrome at i' would have extended at least to the left edge of the palindrome at C):
 *             while S'[R] == S'[L]:
 *                 increment P[i]
 *                 increment R
 *
 *         If the palindrome at i extends past the palindrome at C:
 *             Update C = i
 *
 *         increment i
 *
 *     return max(P)
 */
public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {

        int n = s.length();
        String s2Str = "|";
        int [] p = new int[ 2 * n + 1];
        p[0] = 0;
        for (int i = 0; i < n; i++) {
            s2Str = s2Str + s.charAt(i) + "|";
            p[2 * i + 1] = 0;
            p[2 * i + 2] = 0;
        }

        char[] s2 = s2Str.toCharArray();

        int c = 0, r = 0; // Here the first element in s2 has been processed.
        int m = 0; // The walking indices to compare if two elements are the same.
        n = 0;
        for (int i = 1; i < s2.length; i++) {
            if ( i > r ) {
                p[i] = 0;
                m = i - 1;
                n = i + 1;
            } else {
                int i2 = c * 2 - i;
                if (p[i2] < (r - i - 1)) {
                    p[i] = p[i2];
                    m = -1; // This signals bypassing the while loop below.
                } else {
                    p[i] = r - i;
                    n = r + 1;
                    m = i * 2 - n;
                }
            }
            while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
                p[i]++;
                m--;
                n++;
            }
            if ((i + p[i]) > r) {
                c = i;
                r = i + p[i];
            }
        }
        int len = 0; c = 0;
        for (int i = 1; i < s2.length; i++) {
            if (len < p[i]) {
                len = p[i];
                c = i;
            }
        }
        char[] ss = Arrays.copyOfRange(s2, c - len, c + len + 1);
        String longestPallin = new String(ss);
        return longestPallin.replaceAll(Pattern.quote("|"), "");

    }

    public static void main(String[] args) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindrome("yyabbaxx"));
    }
}
