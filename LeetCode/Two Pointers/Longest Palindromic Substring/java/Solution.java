class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        String maxPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j - i + 1 > maxPalindrome.length()) {
                    if (isPalindrome(s, i, j)) {
                        maxPalindrome = s.substring(i, j + 1);
                    }
                }
            }
        }
        return maxPalindrome;
    }
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}