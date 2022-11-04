class Solution {
   public String reverseVowels(String s) {
   HashSet<Character> set  = new HashSet<Character>();
   set.add('a');
   set.add('e');
   set.add('i');
   set.add('o');
   set.add('u');
   set.add('A');
   set.add('E');
   set.add('I');
   set.add('O');
   set.add('U');
   char[] arr = s.toCharArray();
   Stack<Character> stack = new Stack<Character>();
    for(int i =0;i<arr.length;i++)
   {
	   if(set.contains(arr[i]))
	   {
		   stack.push(arr[i]);
	   }
   }
       //System.out.println("stack -->>"+stack);
   for(int i =0;i<arr.length;i++)
   {
	   if(set.contains(arr[i]))
       {
           // System.out.println("arr[i] -->>"+arr[i]);
           arr[i] = stack.pop();
       }
		   
     //  System.out.println("arr[i] -->>"+arr[i]);
   }
   
   return new String(arr);
   
}

}