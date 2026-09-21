class Solution {
    public int findKthNumber(int m, int n, int k) {
        long s = 1, e = (long) m * n;

        while (s < e) {
            long mid = s + (e - s) / 2;
            long curr = 0;

            for (int i = 1; i <= m; i++) {
                if (curr >= k) break;
                curr += Math.min(n, mid / i);
            }

            if (curr >= k) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return (int) e;
    }
}
