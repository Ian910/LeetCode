class Solution {
    public String frequencySort(String s) {
        int[][] data = new int[62][2];
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i);
            if (num < 58) {
                data[num - 48][0]++;
                data[num - 48][1] = num;
            } else if (num < 91) {
                data[num - 55][0]++;
                data[num - 55][1] = num;
            } else {
                data[num - 61][0]++;
                data[num - 61][1] = num;
            }
        }

        Arrays.sort(data, (o1, o2) -> o2[0] - o1[0]);
        StringBuilder sb = new StringBuilder();

        for (int[] dataSet : data) {
            if (dataSet[1] == 0) break;
            char temp = (char) dataSet[1];
            for (int i = dataSet[0]; i > 0; i--) sb.append(temp);
        }

        return sb.toString();
    }
}