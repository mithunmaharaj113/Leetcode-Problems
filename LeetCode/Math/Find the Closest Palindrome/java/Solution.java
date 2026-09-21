class Solution {
    public long convertToPal(long num) {
        String str = String.valueOf(num);
        int n = str.length();
        int firstHalf = n / 2;
        char[] chars = str.toCharArray();

        for (int i = 0; i < firstHalf; i++) {
            chars[n - 1 - i] = chars[i];
        }

        return Long.parseLong(new String(chars));
    }

    public long findPrevPal(long num) {
        long left = 0, right = num - 1;
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long currPal = convertToPal(mid);

            if (currPal < num) {
                ans = currPal;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public long findNextPal(long num) {
        long left = num + 1, right = (long)1e18;
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long currPal = convertToPal(mid);

            if (currPal > num) {
                ans = currPal;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long nextPal = findNextPal(num);
        long prevPal = findPrevPal(num);

        if (Math.abs(prevPal - num) <= Math.abs(nextPal - num)) {
            return String.valueOf(prevPal);
        }
        return String.valueOf(nextPal);
    }
}