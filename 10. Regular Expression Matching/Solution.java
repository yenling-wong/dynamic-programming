public class Solution {
    public static boolean isMatch(String text, String pattern) {
        boolean[][] table = new boolean[text.length() + 1][pattern.length() + 1];
        table[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match = i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');

                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    table[i][j] = table[i][j + 2] || (first_match && table[i + 1][j]);
                } else {
                    table[i][j] = first_match && table[i + 1][j + 1];
                }
            }
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        return table[0][0];
    }

    public static void main(String[] args) {
        String text = "ab";
        String pattern = ".*";
        boolean match = isMatch(text, pattern);
        System.out.println(match);
    }
}
