class Solution {
    public int hIndex(int[] citations) {
        citations = mergeSort(citations);
        int len = citations.length;
        for (int i = 0; i < len; ++i) if (citations[i] >= len - i) return len - i;
        return 0;
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int iLeft = 0, iRight = 0;
        while (iLeft < left.length && iRight < right.length) {
            if (left[iLeft] < right[iRight]) result[iLeft + iRight] = left[iLeft++];
            else result[iLeft + iRight] = right[iRight++];
        }
        while (iLeft < left.length) result[iLeft + iRight] = left[iLeft++];
        while (iRight < right.length) result[iLeft + iRight] = right[iRight++];
        return result;
    }

    private int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = (int) Math.floor(array.length / 2);
        int[] leftArray = Arrays.copyOf(array, mid);
        int[] rightArray = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(leftArray), mergeSort(rightArray));
    }
}