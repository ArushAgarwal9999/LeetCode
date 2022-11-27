class Solution {
   public static int countPalindromes(String s) {
       if(s.length()<5)
           return 0;
		 
		 long[][][] left = new long[s.length()][10][10];
		 long[][][] right = new long[s.length()][10][10];
		 int[] count = new int[10];
		 count[s.charAt(0)-'0']++;
		 for(int i = 1;i<s.length();i++)
		 {
			 int current = s.charAt(i)-'0';
			 for(int j = 0;j<10;j++)
			 {
				 for(int k = 0;k<10;k++)
				 {
					 left[i][j][k]=left[i-1][j][k];
				 }
			 }
			 for(int j=0;j<10;j++)
			 {
				 left[i][j][current]+=count[j];
			 }
             count[current]++;
		 }
		 Arrays.fill(count, 0);
		 count[s.charAt(s.length()-1)-'0']++;
		 for(int i = s.length()-2;i>=0;i--)
		 {
			 int current = s.charAt(i)-'0';
			 for(int j=0;j<10;j++)
			 {
				 for(int k = 0;k<10;k++)
				 {
					 right[i][j][k]=right[i+1][j][k];
				 }
			 }
			 for(int j = 0;j<10;j++)
			 {
				 right[i][current][j]=right[i+1][current][j]+count[j];
			 }
			 count[current]++;
		 }
		 long result = 0;
		 for(int i=2;i<s.length()-2;i++)
		 {
			 for(int j = 0;j<10;j++)
			 {
				 for(int k=0;k<10;k++)
				 {
					 result=( result  + (left[i-1][j][k]*right[i+1][k][j]))%1000000007;
				 }
			 }
		 }
		 
	        return (int)result;
	        
	    }
}