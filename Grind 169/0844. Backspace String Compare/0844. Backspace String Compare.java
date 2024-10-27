class Solution {
    public boolean backspaceCompare(String s, String t) {
        int indexS = s.length() - 1, indexT = t.length() - 1;
        while (indexS >= 0 || indexT >= 0) {
            int tempSkip = 0;
            while (indexS >= 0) {
                if (s.charAt(indexS) == '#') tempSkip++;
                else if (tempSkip > 0) tempSkip--;
                else break;
                indexS--;
            }

            tempSkip = 0;
            while (indexT >= 0) {
                if (t.charAt(indexT) == '#') tempSkip++;
                else if (tempSkip > 0) tempSkip--;
                else break;
                indexT--;
            }
            
            if ((indexS >= 0) != (indexT >= 0)) return false;

            if (indexS >= 0 && indexT >= 0 && s.charAt(indexS) != t.charAt(indexT))  return false;

            indexS--;
            indexT--;
        }
        return true;
    }
}