class SegmentTree {
    private static class Node {
        int l, r;
        int sum;
        Node lChild;
        Node rChild;
        
        Node(int l, int r) {
            this.l = l;
            this.r = r;
            this.sum = 0;
            this.lChild = null;
            this.rChild = null;
        }
    }
    
    private Node root;
    
    private Node build(int[] nums, int l, int r) {
        Node node = new Node(l, r);
        
        if (l == r) {
            node.sum = nums[l];
            return node;
        }
        
        int mid = (l + r) / 2;
        node.lChild = build(nums, l, mid);
        node.rChild = build(nums, mid + 1, r);
        node.sum = node.lChild.sum + node.rChild.sum;
        
        return node;
    }
    
    private void pointUpdate(Node node, int index, int value) {
        if (node.l == node.r) {
            node.sum = value;
            return;
        }
        
        int mid = (node.l + node.r) / 2;
        if (index <= mid) {
            pointUpdate(node.lChild, index, value);
        } else {
            pointUpdate(node.rChild, index, value);
        }
        node.sum = node.lChild.sum + node.rChild.sum;
    }
    
    private int rangeQuery(Node node, int l, int r) {
        if (l > node.r || r < node.l) {
            return 0;
        }
        
        if (l <= node.l && r >= node.r) {
            return node.sum;
        }
        
        return rangeQuery(node.lChild, l, r) + rangeQuery(node.rChild, l, r);
    }
    
    public SegmentTree(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }
    
    public void update(int index, int val) {
        pointUpdate(root, index, val);
    }
    
    public int rangeQuery(int left, int right) {
        return rangeQuery(root, left, right);
    }
}

class Solution {
    public Map<Integer, Integer> valueToIndexMap(int[] input) {
        Integer[] sorted_input = Arrays.stream(input).boxed().toArray(Integer[]::new);
        Arrays.sort(sorted_input);
        List<Integer> unique = Arrays.stream(sorted_input).distinct().collect(Collectors.toList());
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < unique.size(); i++) {
            map.put(unique.get(i), i);
        }
        return map;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        
        Map<Integer, Integer> compressed = valueToIndexMap(nums);
        int uniqueCount = compressed.size();
        
        int[] freq = new int[uniqueCount];
        SegmentTree st = new SegmentTree(freq);
        
        for (int i = n - 1; i >= 0; i--) {
            int compressedIndex = compressed.get(nums[i]);
            
            if (compressedIndex > 0) {
                result.set(i, st.rangeQuery(0, compressedIndex - 1));
            }
            
            freq[compressedIndex]++;
            st.update(compressedIndex, freq[compressedIndex]);
        }
        
        return result;
    }
}