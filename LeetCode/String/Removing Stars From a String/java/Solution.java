class Solution {
    public String removeStars(String s) {
       Stack<Character> stack=new Stack();
       for(char c : s.toCharArray())
       {
        if(c=='*')
        stack.pop();
        else
        stack.push(c);
       } 
       StringBuilder b =new StringBuilder();
       for(char c: stack)
       b.append(c);
       return b.toString();
    }
}