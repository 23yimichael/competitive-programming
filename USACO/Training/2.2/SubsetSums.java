/*
ID: 23yimic1
LANG: JAVA
PROG: subset
*/

import java.util.*;
import java.io.*;

class subset {
    static boolean debug = false;
    static int n, maxSum = 0;
    static int[] a;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("subset.in"));
        PrintWriter out = new PrintWriter(new FileWriter("subset.out"));

        n = Integer.parseInt(in.readLine());
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = i;
            maxSum += i;
        }

        if (maxSum % 2 != 0) {
            out.println(0);
            out.close();
            return;
        }

        dp = new int[n + 1][maxSum / 2 + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxSum / 2; j++) {
                dp[i][j] += dp[i - 1][j];
                if (j - a[i] > -1)
                    dp[i][j] += dp[i - 1][j - a[i]];
            }
        }

        out.println(dp[n][maxSum / 2]);
        out.close();

        if (debug) {
            System.out.println(n);
            for (int[] row : dp)
                System.out.println(Arrays.toString(row));
        }
    }
}
