class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int lp=0;
        int max=0;
        HashSet<Character>set=new HashSet<>();
        for(int rp=0;rp<n;rp++){
            while(set.contains(s.charAt(rp))){
                
                set.remove(s.charAt(lp));
                lp++;
            }
            set.add(s.charAt(rp));
            max=Math.max(rp-lp+1,max);
        }
        return max;
    }
}