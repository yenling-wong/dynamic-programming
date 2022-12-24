public class Solution {
    public static String longestPalindrome(String s) {
        int n = s.length();
        int[][] table = new int[n][n];
        int start = 0;
        int end = 0;
        int max_length = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    table[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if ((j - i) == 1) {
                        table[i][j] = 1;
                    } else {
                        table[i][j] = table[i + 1][j - 1];
                    }
                } else {
                    table[i][j] = 0;
                }

                if (table[i][j] == 1 && (j - i + 1) > max_length) {
                    max_length = j - i;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }
    public static void main(String[] args) {
        String s = "babad";
        String t = longestPalindrome(s);
        System.out.println(t);
    }

}