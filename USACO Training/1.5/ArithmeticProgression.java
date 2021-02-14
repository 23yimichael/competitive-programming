/*
ID: 23yimic1
LANG: JAVA
PROG: ariprog
*/

import java.util.*;
import java.io.*;

class ariprog {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new FileWriter("ariprog.out"));

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        boolean[] bisquares = new boolean[m * m * 2 + 1];
        for (int p = 0; p <= m; p++)
            for (int q = 0; q <= m; q++)
                bisquares[(p * p) + (q * q)] = true;
        ArrayList<int[]> ans = new ArrayList<>();
        for (int a = 0; a <= (2 * (m * m)) - n; a++) {
            if (!bisquares[a])
                continue;
            for (int b = 1; b * (n - 1) <= (2 * (m * m) - a); b++) {
                boolean dp = false;
                for (int i = 0; i < n; i++) {
                    if (!bisquares[(a + (i * b))]) {
                        dp = true;
                        break;
                    }
                }
                if (!dp)
                    ans.add(new int[] { a, b });
            }
        }
        Collections.sort(ans, (a, b) -> a[1] - b[1]);
        for (int[] a : ans) {
            out.println(a[0] + " " + a[1]);
        }
        if (ans.isEmpty())
            out.println("NONE");
        out.close();
    }
}
