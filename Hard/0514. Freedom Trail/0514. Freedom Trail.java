class Solution {
    public int findRotateSteps(String ring, String key) {
        char preKeyChar = '\0';
        int ans = 0, lenRing = ring.length(), lenKey = key.length(), currIndex;
        List<Integer> preList = new ArrayList<>();
        preList.add(0);

        List<List<Integer>> characterIndexList = new ArrayList<>(26);
        for (currIndex = 0; currIndex < 26; ++currIndex) characterIndexList.add(new ArrayList<>());
        for (currIndex = 0; currIndex < lenRing; ++currIndex)
            characterIndexList.get(ring.charAt(currIndex) - 'a').add(currIndex);

        for (int keyIndex = 0; keyIndex < lenKey; ++keyIndex) {
            int afterIndex = keyIndex;
            while (afterIndex < key.length() && preKeyChar == key.charAt(afterIndex)) ++afterIndex;
            if (afterIndex != keyIndex) {
                ans += afterIndex - keyIndex;
                if (afterIndex == key.length()) break;
                keyIndex = afterIndex;
            }

            char currKeyChar = key.charAt(keyIndex);
            List<Integer> currList = new ArrayList<>();

            for (int ringIndex : characterIndexList.get(currKeyChar - 'a')) {
                int min;
                if (keyIndex == 0) min = Math.min(ringIndex, lenRing - ringIndex) + preList.get(0) + 1;
                else {
                    List<Integer> preChacacterIndex = characterIndexList.get(preKeyChar - 'a');
                    int num = Math.abs(preChacacterIndex.get(0) - ringIndex);
                    min = Math.min(num, lenRing - num) + preList.get(0) + 1;
                    for (int i = 1; i < preList.size(); ++i) {
                        num = Math.abs(preChacacterIndex.get(i) - ringIndex);
                        num = Math.min(num, lenRing - num) + preList.get(i) + 1;
                        if (num < min) min = num;
                    }
                }
                currList.add(min);
            }

            preList = currList;
            preKeyChar = currKeyChar;
        }

        int min = preList.get(0);
        for (int num : preList) if (num < min) min = num;
        return ans + min;
    }
}