class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans=new StringBuilder("");
        int depth=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                depth++;
                if(depth>1){
                    ans.append(s.charAt(i));
                }
            }
            if(s.charAt(i)==')'){
                depth--;
                if(depth>0){
                    ans.append(s.charAt(i));
                }
            }

        }
        return ans.toString();
    }
}