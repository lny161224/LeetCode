//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 824 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int time = n/2;
        int count = 1;
        for(int i=0;i<time;i++){
            for (int j=i;j<n-i-1;j++){
                res[i][j] = count++;
            }
            for(int j=i;j<n-i-1;j++){
                res[j][n-i-1] = count++;
            }
            for(int j=n-i-1;j>i;j--){
                res[n-i-1][j] = count++;
            }
            for (int j=n-i-1;j>i;j--){
                res[j][i] = count++;
            }
        }
        if(n%2==1)res[time][time] = count++;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
