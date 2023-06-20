class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        for(int i=1;i<n;i++){
            int m = triangle[i].length;
            for(int j =0;j<m;j++){
                triangle[i][j] += Math.max(j > i-1 ? 0 : triangle[i-1][j],j-1 < 0 ? 0 : triangle[i-1][j-1]);
                answer = Math.max(answer,triangle[i][j]);
            }
        }          
        return answer;
    }
}