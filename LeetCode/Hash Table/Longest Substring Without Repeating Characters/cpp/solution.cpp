class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            for (int i = left; i < right; i++) {
                if (s[i] == s[right]) {
                    left = i + 1;
                    break;
                }
            }

            ans = max(ans, right - left + 1);
        }

        return ans;
    }
};