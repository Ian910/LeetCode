class Solution {
    public int candy(int[] ratings) {
       int n = ratings.length;
       int[] candies = new int[n];

       candies[0] = 1;
       for (int i = 1; i < n; ++i) {
           if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
           else candies[i] = 1;
       }

       for (int i = n - 2; i >= 0; --i) {
           if (ratings[i] > ratings[i + 1]) {
               if (candies[i] < candies[i + 1] + 1)
                   candies[i] = candies[i + 1] + 1;
           }
       }

       int total = 0;
       for (int candy : candies) total += candy;
       return total;
   }
}