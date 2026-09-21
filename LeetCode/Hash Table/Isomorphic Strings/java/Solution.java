class Solution {
    public boolean isIsomorphic(String s, String t) {

        int map1[] = new int[256];
        int map2[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char ch = t.charAt(i);
            if (map1[c] == 0 && map2[ch] == 0) {
                map1[c] = ch;
                map2[ch] = c;
            } else {
                if (map1[c] != ch || map2[ch] != c) 
                return false;
            }
        }
        return true;
    }
}