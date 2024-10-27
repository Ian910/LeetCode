class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int max = -100001;
        int row = grid.size(), col = grid.get(0).size();
        int[] tempRecords = new int[col];

        List<Integer> temp = grid.get(row - 1);
        tempRecords[col - 1] = temp.get(col - 1);


        for (int i = col - 2; i >= 0; --i) {
            int currNum = temp.get(i);
            max = Math.max(max, tempRecords[i + 1] - currNum);
            tempRecords[i] = Math.max(tempRecords[i + 1], currNum);
        }

        for (int i = row - 2; i >= 0; --i) {
            temp = grid.get(i);
            int currNum = temp.get(col - 1);
            max = Math.max(max, tempRecords[col - 1] - currNum);
            tempRecords[col - 1] = Math.max(tempRecords[col - 1], currNum);

            for (int j = col - 2; j >= 0; j--) {
                currNum = temp.get(j);
                tempRecords[j] = Math.max(tempRecords[j + 1], tempRecords[j]);
                max = Math.max(max, tempRecords[j] - currNum);
                tempRecords[j] = Math.max(tempRecords[j], currNum);
            }
        }

        return max;
    }
}