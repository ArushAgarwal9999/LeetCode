class Solution {
    public void setZeroes1(int[][] matrix) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        boolean flag=false;
        for(int i=0;i<m;i++)
        {
            if(matrix[i][0]==0) flag=true;
            for(int j=1;j<n;j++)
            {
                
                if(matrix[i][j]==0)
                {
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=1;j--)
            {
                if(matrix[i][j]!=0)
                {
                    if(matrix[i][0]==0 || matrix[0][j]==0)
                        matrix[i][j]=0;
                }
            }
            if(flag==true)
            {
                matrix[i][0]=0;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        boolean isColumn = false;
        for(int i = 0;i<matrix.length;i++)
        {
            if(matrix[i][0]==0)
        			isColumn=true;
        	for(int j = 1;j<matrix[i].length;j++)
        	{
        		
        			if(matrix[i][j]==0)
        			{
        				matrix[i][0] = 0;
        				matrix[0][j] = 0;
        			}
        	}
        	
        }
        for(int i = matrix.length-1;i>=0;i--)
    	{
    		for(int j = matrix[i].length-1;j>=1;j--)
    		{
    			if( (matrix[i][0]==0|| matrix[0][j]==0))
    				matrix[i][j]=0;
    		}
             if(isColumn)
            {
                 matrix[i][0] = 0;
            }
            
    	}
       
        
    }
}