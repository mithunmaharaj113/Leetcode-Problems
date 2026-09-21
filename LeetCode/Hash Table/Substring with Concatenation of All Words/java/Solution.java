class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;

        int wordlen = words[0].length();
        int totlen = wordlen * words.length;
        int n = s.length();

        HashMap<String, Integer> count = new HashMap<>();
        for (String h : words) {
            count.put(h, count.getOrDefault(h, 0) + 1);
        }

        for (int i = 0; i < wordlen; i++) {
            int left = i, right = i;
            HashMap<String, Integer> seen = new HashMap<>();

            while (right + wordlen <= n) {
                String word = s.substring(right, right + wordlen);
                right += wordlen;

                if (count.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);

                    while (seen.get(word) > count.get(word)) {
                        String leftWord = s.substring(left, left + wordlen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordlen;
                    }

                    if (right - left == totlen)
                        result.add(left);
                } else {
                    seen.clear();
                    left = right;
                }
            }
        }

        return result;
    }
}