class Solution {
    public void setZeroes(int[][] matrix) {
       boolean[] rowFlag = new boolean[matrix.length];
       boolean[] columnFlag = new boolean[matrix[0].length];
       for(int i = 0;i<matrix.length;i++)
       {
           for(int j = 0;j<matrix[0].length;j++)
           {
               if(matrix[i][j] == 0)
               {
                   rowFlag[i]= true;
                   columnFlag[j] = true;
               }
           }
       }
        for(int i = 0;i<matrix.length;i++)
       {
           for(int j = 0;j<matrix[0].length;j++)
           {
               if(rowFlag[i] || columnFlag[j])
               {
                   matrix[i][j] = 0;
               }
           }
       }
       
    }
}