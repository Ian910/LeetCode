class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int len = arr.length, times = 0, size = 0;
        if (len - k < 2) return len - k;
        int[] lenArr = new int[len];
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            if (i != len - 1 && arr[i] == arr[i + 1]) times++;
            else {
                lenArr[times]++;
                times = 0;
                size++;
            }
        }

        len = 1;
        for (int num : lenArr)
            if (k - num * len >= 0) {
                k -= num * len;
                size -= num;
                len++;
            } else if (k >= len) {
                while (k >= len) {
                    k -= len;
                    size -= 1;
                }
                break;
            } else break;
        return size;
    }
}