class Solution {
    public int calculate(String s) {
        long res = 0;
        long sign = 1;
        long currnt = 0;
        Stack<Long> stack = new Stack<Long>();
        for(int i = 0;i<s.length();i++)
        {
        	if(Character.isDigit(s.charAt(i)))
        	{
        		currnt =(currnt*10+(s.charAt(i)-'0'));
        	}
        	else if(s.charAt(i)=='+'||s.charAt(i)=='-')
        	{
        		res+=sign*currnt;
        		if(s.charAt(i)=='-')
        			sign=-1;
        		else
        			sign=1;
        		currnt=0;
        			
        	}
        	else if(s.charAt(i)=='(')
        	{
        		stack.add(res);
        		stack.add(sign);
        		res = 0;
        		sign = 1;
        		currnt=0;
        	}
        	else if(s.charAt(i)==')')
        	{
        		res+=sign*currnt;
        		res*=stack.pop();
        		res+=stack.pop();
        		currnt=0;
        				
        	}
        	
        }
       // System.out.println("current-->>"+currnt);
        return (int) (res+sign*currnt);
    }
}