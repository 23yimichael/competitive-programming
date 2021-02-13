/*
ID: 23yimic1
LANG: JAVA
PROG: wormhole
*/

import java.util.*;
import java.io.*;

class wormhole {
    static int n;
    static int[] x, y, right, pairs;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter out = new PrintWriter(new FileWriter("wormhole.out"));

        n = Integer.parseInt(in.readLine());
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        right = new int[n];
        pairs = new int[n];
        Arrays.fill(right, -1);
        Arrays.fill(pairs, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (y[i] == y[j] && x[i] < x[j] && (right[i] == -1 || x[j] < x[right[i]]))
                    right[i] = j;
                if (y[i] == y[j] && x[j] < x[i] && (right[j] == -1 || x[i] < x[right[j]]))
                    right[j] = i;
            }
        }
        out.println(solve());
        out.close();
    }

    static int solve() {
        int num = -1;
        for (int i = 0; i < n; i++) {
            if (pairs[i] == -1) {
                num = i;
                break;
            }
        }
        if (num == -1) {
            for (int i = 0; i < n; i++) {
                int pos = i;
                for (int j = 0; j < n; j++) {
                    if (pairs[pos] == -1 || right[pos] == -1)
                        break;
                    pos = pairs[right[pos]];
                    if (i == pos) {
                        return 1;
                    }
                }
            }
            return 0;
        }
        int ret = 0;
        for (int i = num + 1; i < n; i++) {
            if (pairs[i] == -1) {
                pairs[i] = num;
                pairs[num] = i;
                ret += solve();
                pairs[i] = -1;
                pairs[num] = -1;
            }
        }
        return ret;
    }
}
