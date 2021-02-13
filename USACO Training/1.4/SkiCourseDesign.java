/*
ID: 23yimic1
LANG: JAVA
PROG: skidesign
*/

import java.util.*;
import java.io.*;

class skidesign {
    static int n, ans = Integer.MAX_VALUE;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter out = new PrintWriter(new FileWriter("skidesign.out"));

        n = Integer.parseInt(in.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(in.readLine());
        Arrays.sort(a);
        if (a[n - 1] - a[0] <= 17) {
            out.println(0);
            out.close();
            return;
        }
        for (int i = a[0]; i + 17 <= a[n - 1]; i++) {
            int ans2 = 0, ans3 = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] >= i)
                    break;
                ans2 += Math.pow(i - a[j], 2);
            }
            for (int j = n - 1; j > -1; j--) {
                if (a[j] <= i + 17)
                    break;
                ans3 += Math.pow(a[j] - (i + 17), 2);
            }
            ans = Math.min(ans, ans2 + ans3);
        }
        out.println(ans);
        out.close();
    }
}
