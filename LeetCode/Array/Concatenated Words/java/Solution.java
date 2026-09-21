class Solution {
    class Trie {
        Map<Character, Trie> children;
        String word;
        Trie() {
            this.children = new HashMap<>();
            this.word = null;
        }
        void add(String s) {
            Trie node = this;
            for(char c : s.toCharArray()) {
                node = node.children.computeIfAbsent(c, k->new Trie());
            }
            node.word = s;
        }
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root = new Trie();
        for(String word : words) {
            root.add(word);
        }
        List<String> result = new ArrayList<>();

        for(String word : words) {
            Boolean[] dp = new Boolean[word.length()];
            boolean count = isWordConcatenated(root, word, 0, 0, dp);
            if(count) {
                result.add(word);
            }
        }
        
        return result;
        
    }
    
    boolean isWordConcatenated(Trie root, String word, int idx, int wordsSoFar, Boolean[] dp) {
        if(idx == word.length())
            return wordsSoFar > 1;
        
        if(dp[idx] == null) {
            Trie node = root;
            for(int i = idx; i < word.length(); i++) {
                if(!node.children.containsKey(word.charAt(i))) {
                    dp[idx] = false;
                    break;
                }
                node = node.children.get(word.charAt(i));
                if(node.word != null) {
                    boolean found = isWordConcatenated(root, word, i + 1, wordsSoFar+1, dp);
                    if(found) {
                        dp[idx] = true;
                        break;
                    }
                }
            }
            dp[idx] = dp[idx] == null ? false : dp[idx];
        }
        return dp[idx];
    }
}