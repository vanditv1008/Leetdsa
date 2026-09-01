class Solution {
    public String simplifyPath(String path) {
            Stack<String>s=new Stack<>();
        String[] arr=path.split("/");//cuts string whenever / appears
        for(int i=0;i<arr.length;i++){
            String curr=arr[i];
            if(curr.equals("..")){
                 if(!s.isEmpty()){
                    s.pop();
                }
            }else if(curr=="/" || curr.equals(".") || curr.equals("")){
                continue;
            }
            else{
                s.push(curr);
            }
        }
        StringBuilder newstr=new StringBuilder("");
        for(String x:s){
            newstr.append("/");
            newstr.append(x);
        }
        if(newstr.length()==0){
            return "/";
        }
        return newstr.toString();
    }
}