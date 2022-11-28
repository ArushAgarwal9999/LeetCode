//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
   public int wordLadderLength(String beginWord, String endWord, String[] wordList) {
	
	
		HashSet<String> word = new HashSet<String>();
		for(String a:wordList)
			word.add(a);
		
		if(!word.contains(endWord))
			return 0;
		
		int count=1;
		Queue<String> quee= new LinkedList<String>();
		quee.add(beginWord);
		
		while(!quee.isEmpty())
		{
			int size=quee.size();
			while(size>0)
			{
				size--;
				String temp = quee.poll();
				if(temp.equals(endWord))
					return count;
				
				char[] ch = temp.toCharArray();
				for(int i = 0;i<ch.length;i++)
				{
					for(char a='a';a<='z';a++)
					{
						if(ch[i] != a)
						{
							char tmp = ch[i];
							ch[i] = a;
							String newWord = new String(ch);
							if(word.contains(newWord))
							{
								quee.add(newWord);
								word.remove(newWord);
							}
							ch[i] = tmp;
						}
					}
					
				}
			}
			count++;
		}
		
		
		
        return 0;
    }

}