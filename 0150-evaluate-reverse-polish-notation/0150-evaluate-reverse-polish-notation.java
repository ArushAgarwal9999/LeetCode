class Solution {
    public int evalRPN(String[] tokens) {
	
	Stack<Integer> stack = new Stack<Integer>();
	HashSet<String> set = new HashSet<String>();
	set.add("+");
	set.add("-");
	set.add("*");
	set.add("/");
	for(int i = 0;i<tokens.length;i++)
	{
		if(set.contains(tokens[i]))
		{
			int b = stack.pop();
			int a = stack.pop();
			stack.push(dooperation(a,b,tokens[i]));
		}
		else {
			stack.push(Integer.parseInt(tokens[i]));
		}
	}
    return stack.peek();
}
private int dooperation(int a, int b, String operator)
{
	if(operator.equals("/"))
	{
		return a/b;
	}
	else if(operator.equals("*"))
	{
		return a*b;
	}
	else if(operator.equals("+"))
	{
		return a+b;
	}
	else {
		return a-b;
	}
}
}