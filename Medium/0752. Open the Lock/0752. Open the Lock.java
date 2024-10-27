class Solution {
    public int openLock(String[] deadends, String target) {
        int targetNum = Integer.parseInt(target), currTurn = 0;
        if (targetNum == 0) return 0;
        boolean[] visitArray = new boolean[10000];
        for (String deadend : deadends) {
            int num = Integer.parseInt(deadend) - targetNum;
            if ((num == 1 || num == -1) ||
                (num == 10 || num == -10) ||
                (num == 100 || num == -100) ||
                (num == 1000 || num == -1000) && !visitArray[num + targetNum])
                ++currTurn;
            visitArray[num + targetNum] = true;
        }
        if (visitArray[0] || currTurn == 8) return -1;

        // bfs
        currTurn = 0;
        Queue<Integer> currLeaf = new LinkedList<>();
        currLeaf.add(0);
        visitArray[0] = true;
        while (!currLeaf.isEmpty()) {
            ++currTurn;
            for (int times = currLeaf.size() - 1; times >= 0; --times) {
                int baseNum = currLeaf.poll(), digitValue = 10000;

                while (digitValue > 1) {
                    digitValue /= 10;

                    int beforeChangeDigitNum = baseNum / digitValue % 10;
                    int temp1 = baseNum;
                    int temp2 = baseNum;

                    if (beforeChangeDigitNum != 9) temp1 += digitValue;
                    else temp1 -= 9 * digitValue;
                    if (beforeChangeDigitNum == 0) temp2 += 9 * digitValue;
                    else temp2 -= digitValue;

                    if (temp1 == targetNum || temp2 == targetNum) return currTurn;

                    if (!visitArray[temp1]) {
                        visitArray[temp1] = true;
                        currLeaf.add(temp1);
                    }

                    if (!visitArray[temp2]) {
                        visitArray[temp2] = true;
                        currLeaf.add(temp2);
                    }
                }
            }
        }
        return -1;
    }
}