class Solution {
    public String makeGood(String s) {
	Stack<Character> stack = new Stack<Character>();
	for(char c:s.toCharArray())
	{
		if(!stack.isEmpty())
		{
			if(Character.isLowerCase(c) && Character.isUpperCase(stack.peek()) )
			{
				String lower = c+"";
				String upper = stack.peek()+"";
				if(lower.equals(upper.toLowerCase()))
				{
					stack.pop();
					continue;
				}
				
			}
			if(Character.isUpperCase(c) && Character.isLowerCase(stack.peek()))
			{
				String lower = stack.peek()+"";
				String upper = c+"";
				if(lower.equals(upper.toLowerCase()))
				{
					stack.pop();
					continue;
				}
			}
		}
		stack.push(c);
		//System.out.println("stack -->>"+stack);
	}
	StringBuffer  res = new StringBuffer();
	while(!stack.isEmpty())
	{
		res.append(stack.pop());
	}
        return res.reverse().toString();
        }
}