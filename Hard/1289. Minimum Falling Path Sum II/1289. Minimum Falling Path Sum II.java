class Solution {
    public int minFallingPathSum(int[][] grid) {
        int len = grid.length;
        int[][] temp = new int[2][3];
        temp[1][0] = 20001;
        temp[1][1] = 20001;

        for(int i = 0; i < len; ++i) {
            int lastRowMinColumn = temp[1][2];
            
            for(int j = 0; j < len; ++j) {
                int num = grid[i][j];
                if (lastRowMinColumn == j) num += temp[0][1];
                else num += temp[0][0];

                if (num <= temp[1][0]) {
                    temp[1][1] = temp[1][0];
                    temp[1][0] = num;
                    temp[1][2] = j;
                } else if (num < temp[1][1]) temp[1][1] = num;
            }
            
            temp[0][0] = temp[1][0];
            temp[0][1] = temp[1][1];
            temp[0][2] = temp[1][2];
            temp[1][0] = 20001;
            temp[1][1] = 20001;
        }


        return temp[0][0];   
    }
}