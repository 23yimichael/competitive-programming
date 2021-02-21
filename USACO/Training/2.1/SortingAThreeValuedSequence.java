/*
ID: 23yimic1
LANG: JAVA
PROG: sort3
*/

import java.util.*;
import java.io.*;

class sort3 {
    static boolean debug = true;
    static int n, ans = 0;
    static int[] a;
    static int[][] dp;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new FileWriter("sort3.out"));

        n = Integer.parseInt(in.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(in.readLine());
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        dp = new int[3][3];
        int index = 0;
        for (int key : map.keySet()) {
            int value = map.get(key);
            for (int i = index; i < index + value; i++)
                dp[key - 1][a[i] - 1]++;
            index += value;
        }

        for (int[] row : dp)
            System.out.println(Arrays.toString(row));
        // check for pairs
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    continue;
                if (dp[i][j] != 0 && dp[j][i] != 0) {
                    int num = Math.min(dp[i][j], dp[j][i]);
                    dp[i][j] -= num;
                    dp[j][i] -= num;
                    ans += num;
                }
            }
        }

        // check for triplets
        int triplets = 0;
        int maxTrip = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    continue;
                if (dp[i][j] != 0) {
                    triplets++;
                    maxTrip = Math.max(maxTrip, dp[i][j]);
                }
            }
        }

        System.out.println(ans);
        System.out.println(triplets);
        out.println(ans + ((triplets / 3) * 2 * maxTrip));
        out.close();

        if (debug) {
            System.out.println(Arrays.toString(a));
            System.out.println(map);
            for (int[] row : dp)
                System.out.println(Arrays.toString(row));
        }
    }
}
