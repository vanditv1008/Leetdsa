
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        int maxDiff = 0;

        long k = (long) k1 + k2;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        int low = 0, high = maxDiff;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long operations = 0;

            for (int d : diff) {
                operations += Math.max(0, d - mid);

                if (operations > k) {
                    break;
                }
            }

            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int target = low;
        long used = 0;
        long ans = 0;

        for (int d : diff) {
            used += Math.max(0, d - target);
            int reduced = Math.min(d, target);
            ans += (long) reduced * reduced;
        }

        long remaining = k - used;

        for (int d : diff) {
            if (remaining > 0 && d >= target && target > 0) {
                ans -= (long) target * target
                     - (long) (target - 1) * (target - 1);
                remaining--;
            }
        }

        return ans;
    }
}
