class Solution {
    public String removeDuplicates(String s) {
    Stack<Character> stack = new Stack<Character>();
    StringBuffer str = new StringBuffer();
    for(int i=0;i<s.length();i++)
    {
    	if(!stack.isEmpty() && stack.peek()==s.charAt(i))
    		stack.pop();
    	else
    		stack.add(s.charAt(i));
    }
    while(!stack.isEmpty())
    {
    	str.append(stack.pop());
    }
    return str.reverse().toString();
}
}