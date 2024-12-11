package cn.bw.leetcode;

public class L63不同路径II {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows=obstacleGrid.length, cols=obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        if(obstacleGrid[0][0]==1)return 0;
        for(int i=0;i<rows;i++){
            if(obstacleGrid[i][0]==1){
                break;
            }
            dp[i][0]=1;
        }

        for(int j=0;j<cols;j++){
            if(obstacleGrid[0][j]==1){
                break;
            }
            dp[0][j]=1;
        }

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[rows-1][cols-1];

    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {

        int rows=obstacleGrid.length;
        int cols=obstacleGrid[0].length;

        int[] dp = new int[cols];
        dp[0]=obstacleGrid[0][0]==1?0:1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(obstacleGrid[i][j]==1){
                    dp[j]=0;
                }else if(j>0){
                    dp[j] +=dp[j-1];
                }
            }
        }

        return dp[cols-1];
    }

}
