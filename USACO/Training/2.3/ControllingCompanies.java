/*
ID: 23yimic1
LANG: JAVA
PROG: concom
*/

import java.util.*;
import java.io.*;

class concom {
    static boolean debug = false;
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;
    static int n;
    static int[][] dp;
    static boolean[][] used;

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new FileReader("concom.in"));
        out = new PrintWriter(new FileWriter("concom.out"));

        n = Integer.parseInt(in.readLine());
        dp = new int[101][101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        in.close();

        used = new boolean[101][101];
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (i != j && !used[i][j] && dp[i][j] > 50) {
                    used[i][j] = true;
                    for (int k = 1; k <= 100; k++) {
                        dp[i][k] += dp[j][k];
                        if (used[j][k])
                            used[i][k] = true;
                    }
                    j = 0;
                }
            }
        }

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (i != j && used[i][j])
                    out.println(i + " " + j);
            }
        }
        out.close();

        if (debug) {
            System.out.println(n);
            for (int[] row : dp)
                System.out.println(Arrays.toString(row));
        }
    }
}
