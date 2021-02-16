/*
ID: 23yimic1
LANG: JAVA
PROG: numtri
*/

import java.util.*;
import java.io.*;

class numtri {
    static int r;
    static int[][] ar, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new FileWriter("numtri.out"));

        r = Integer.parseInt(in.readLine());
        ar = new int[r][r];
        dp = new int[r][r];
        int ans = 0;
        for (int i = 1; i <= r; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < i; j++) {
                ar[i - 1][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= r; i++) {
            if (i == 1) {
                dp[0][0] = ar[0][0];
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (j == 0)
                    dp[i - 1][j] = ar[i - 1][j] + dp[i - 2][j];
                else
                    dp[i - 1][j] = ar[i - 1][j] + Math.max(dp[i - 2][j - 1], dp[i - 2][j]);
                ans = Math.max(ans, dp[i - 1][j]);
            }
        }
        out.println(ans);
        out.close();
    }
}
