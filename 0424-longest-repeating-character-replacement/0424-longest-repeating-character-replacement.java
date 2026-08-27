class Solution {
    public int characterReplacement(String s, int k) {
        int lp=0;
        int max=0;
        int maxfreq=0;
        int[] arr=new int[26];
        for(int rp=0;rp<s.length();rp++){
            arr[s.charAt(rp)-'A']++;
            maxfreq=Math.max(maxfreq,arr[s.charAt(rp)-'A']);
             while ((rp - lp + 1) - maxfreq > k) {
                arr[s.charAt(lp) - 'A']--;
                lp++;
            }
            max=Math.max(max,rp-lp+1);

        }
        return max;
    }
}