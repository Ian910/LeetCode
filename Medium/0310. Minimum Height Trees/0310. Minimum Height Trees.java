import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        return new AbstractList<Integer>() {
            List<Integer> dotList;

            @Override
            public int size() {
                init(n);
                return dotList.size();
            }

            @Override
            public Integer get(int index) {
                init(n);
                return dotList.get(index);
            }

            private void init(int n) {
                if (dotList != null)
                    return;
                dotList = new LinkedList<>();

                if (n == 1) {
                    dotList.add(0);
                    return;
                }

                int[][] edgeStatistics = new int[n][2];
                for (int[] edge : edges) {
                    ++edgeStatistics[edge[0]][0];
                    ++edgeStatistics[edge[1]][0];
                    edgeStatistics[edge[0]][1] ^= edge[1];
                    edgeStatistics[edge[1]][1] ^= edge[0];
                }

                for (int i = 0; i < n; ++i)
                    if (edgeStatistics[i][0] == 1)
                        dotList.add(i);

                while (n > 2) {
                    n -= dotList.size();
                    List<Integer> newList = new ArrayList<>();
                    for (int currDot : dotList) {
                        int otherDot = edgeStatistics[currDot][1];
                        edgeStatistics[otherDot][1] ^= currDot;
                        if (--edgeStatistics[otherDot][0] == 1)
                            newList.add(otherDot);
                    }
                    dotList = newList;
                }
            }
        };
    }
}