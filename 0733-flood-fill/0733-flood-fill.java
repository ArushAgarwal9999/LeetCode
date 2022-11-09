class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc])
            return image;
	dfs(sr, sc, image[sr][sc], color, image);
    return image;
}
public void dfs(int i, int j , int prevColur, int colur, int[][] image)
{
	if(i<0|| i>=image.length || j<0||j>=image[0].length)
		return ;
	if(image[i][j] ==prevColur)
    {
        image[i][j] = colur;
	dfs(i+1, j, prevColur, colur, image);
	dfs(i-1, j, prevColur, colur, image);
	dfs(i, j+1, prevColur, colur, image);
	dfs(i, j-1, prevColur, colur, image);
    }
	
}
}