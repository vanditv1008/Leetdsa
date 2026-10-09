
class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int need = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                // Every '(' requires two ')'
                need += 2;
                // If need becomes odd, insert one ')'
                if (need % 2 == 1) {
                    ans++;
                    need--;
                }
            } else {
                need--;
                // Extra ')' without a matching '('
                if (need < 0) {
                    ans++;
                    need = 1;
                }
            }
        }
        return ans + need;
    }
}