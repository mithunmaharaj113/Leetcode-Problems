class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Queue<Integer> remain = new LinkedList<>();
        for (int a : nums) {
            remain.add(a);
        }
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> take = new ArrayList<>();
        permutation(ans, take, remain);
        return new ArrayList<>(ans);
    }

    public void permutation(Set<List<Integer>> ans, List<Integer> take, Queue<Integer> remain) {
        if (remain.isEmpty()) {
            ans.add(new ArrayList<>(take));
            return;
        }

        int curr = remain.remove();
        for (int i = 0; i <= take.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            int s = 0;
            for (; s < i; s++) {
                temp.add(take.get(s));
            }
            temp.add(curr);
            for (; s < take.size(); s++) {
                temp.add(take.get(s));
            }
            permutation(ans, temp, remain);
        }
        remain.add(curr);
    }
}