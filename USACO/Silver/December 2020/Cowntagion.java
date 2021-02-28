import java.util.*;
import java.io.*;

class Cowntagion {
    static boolean debug = false;
    static BufferedReader in;
    static StringTokenizer st;
    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        dp = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            dp[a]++;
            dp[b]++;
        }

        int days = 0;
        for (int i = 1; i <= n; i++) {
            int infected = 1;
            while (infected <= dp[i] - (i == 1 ? 0 : 1)) {
                infected *= 2;
                days++;
            }
            days += dp[i] - (i == 1 ? 0 : 1);
        }
        System.out.println(days);
        if (debug) {
            System.out.println(n);
            System.out.println(Arrays.toString(dp));
        }
    }
}
