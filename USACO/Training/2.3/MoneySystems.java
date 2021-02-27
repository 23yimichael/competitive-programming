/*
ID: 23yimic1
LANG: JAVA
PROG: money
*/

import java.util.*;
import java.io.*;

class money {
    static boolean debug = true;
    static BufferedReader in;
    static PrintWriter out;
    static int v, n, ans = 0;
    static int[] a;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new FileReader("money.in"));
        out = new PrintWriter(new FileWriter("money.out"));

        StringTokenizer st = new StringTokenizer(in.readLine());
        v = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        a = new int[v];
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(in.readLine());
            while (st.hasMoreTokens()) {
                a[i] = Integer.parseInt(st.nextToken());
                i++;
            }
            i--;
        }

        in.close();

        dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < v; i++) {
            for (int j = a[i]; j <= n; j++) {
                if (j - a[i] > -1)
                    dp[j] += dp[j - a[i]];
            }
        }

        out.println(dp[n]);
        out.close();

        if (debug) {
            System.out.println(v);
            System.out.println(n);
            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(dp));
        }
    }
}
