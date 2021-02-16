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
        for (int i = 1; i <= r; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < i; j++)
                ar[i - 1][j] = Integer.parseInt(st.nextToken());
        }
        dp = new int[r][r];
        out.println(solve(0, 0));
        out.close();
    }

    static int solve(int x, int y) {
        if (y == r || x == r)
            return 0;
        if (dp[x][y] > 0)
            return dp[x][y];
        return dp[x][y] = ar[x][y] + Math.max(solve(x + 1, y), solve(x + 1, y + 1));
    }
}
