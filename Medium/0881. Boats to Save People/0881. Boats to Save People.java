class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int size = limit / 2, ct = 0;
        int[] record = new int[size];

        for (int weight : people) {
            if (weight >= limit) ++ct;
            else {
                boolean isBigThanSize = weight > size;
                int index = (isBigThanSize ? limit - weight : weight) - 1;

                if (record[index] > 0) {
                    if (isBigThanSize) {
                        ct++;
                        record[index]--;
                    } else record[index]++;
                } else if (record[index] < 0) {
                    if (isBigThanSize) record[index]--;
                    else {
                        record[index]++;
                        ct++;
                    }
                } else {
                    record[index] = isBigThanSize ? -1 : 1;
                }
            }
        }
        
        if (limit % 2 == 0) {
            ct += (record[size - 1]) / 2;
            record[size - 1] -= (record[size - 1]) / 2 * 2;
        }

        int i = 0;
        while (record[i] <= 0) {
            ct -= record[i];
            if (++i >= size) break;
        }
        
        if (i < size) {
            if (i == size - 1) return ct + Math.abs(record[i]);

            int start = i, end = i + 1; // start +, end -, 小到大
            while (record[end] >= 0) if (++end >= size) break;

            while (start < size && end < size) {
                int smallTotal = record[start], bigTotal = -record[end];

                if (start > end) {
                    while (start > ++end) if (record[end] < 0) bigTotal -= record[end];
                    ct += bigTotal;
                    end = start + 1;
                    while (end < size && record[end] >= 0) ++end;
                    continue;
                }

                if (smallTotal > bigTotal) {
                    ct += bigTotal;
                    record[start] -= bigTotal;

                    end++;
                    while (end < size && record[end] >= 0) ++end;
                } else if (smallTotal < bigTotal) {
                    ct += smallTotal;
                    record[end] += smallTotal;

                    start++;
                    while (start < size && record[start] <= 0) ++start;
                } else {
                    ct += smallTotal;

                    start++;
                    end++;
                    while (start < size && record[start] <= 0) ++start;
                    while (end < size && record[end] >= 0) ++end;
                }
            }

            int tempSum = 0;
            while (start < size) {
                int num = record[start];
                if (num > 0) tempSum += num;
                if (++start >= size) return ct + (tempSum + 1) / 2;
            }

            while (end < size) {
                int num = record[end];
                if (num < 0) tempSum -= num;
                if (++end >= size) return ct + tempSum;
            }
        }
        return ct;
    }
}