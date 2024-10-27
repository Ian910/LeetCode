class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
         int[] orderCard = orderCard(deck.length);
         Arrays.sort(deck);
         for (int i = 0; i < deck.length; ++i) orderCard[i] = deck[orderCard[i]];
         return orderCard;
     }
 
     public int[] orderCard(int num) {
         if (num < 4) {
             if (num == 3) return new int[]{0, 2, 1};
             if (num == 2) return new int[]{0, 1};
             return new int[]{0};
         }
 
         int preNum = num / 2;
         int[] ans = new int[num];
         for (int i = 0; i < num; i += 2) ans[i] = i / 2;
 
         int[] preAns = orderCard(preNum);
         if (num % 2 == 1) {
             ans[1] = preAns[preNum - 1] + preNum + 1;
             for (int i = 3; i < num; i += 2) ans[i] = preAns[i / 2 - 1] + preNum + 1;
         } else {
             for (int i = 1; i < num; i += 2) ans[i] = preAns[i / 2] + preNum;
         }
         return ans;
     }
 }