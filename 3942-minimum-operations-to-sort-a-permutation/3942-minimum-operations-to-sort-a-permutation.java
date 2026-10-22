class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int s = nums[0];
        boolean asc = true, desc = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (s + i) % n) asc = false;
            if (nums[i] != ((s - i) % n + n) % n) desc = false;
        }

        int best = Integer.MAX_VALUE;

        if (asc) {
            if (s == 0) return 0;
            // shift left (n - s) times, or reverse + shift left s times + reverse
            best = Math.min(best, Math.min(n - s, s + 2));
        }
        if (desc) {
            int t = (s + 1) % n;
            // shift left t times then reverse, or reverse then shift left (n - t) times
            best = Math.min(best, 1 + Math.min(t, (n - t) % n));
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }
}