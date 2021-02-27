/*
ID: 23yimic1
LANG: JAVA
PROG: zerosum
*/

import java.util.*;
import java.io.*;

class zerosum {
    static boolean debug = true;
    static BufferedReader in;
    static PrintWriter out;
    static int n;
    static TreeSet<String> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new FileReader("zerosum.in"));
        out = new PrintWriter(new FileWriter("zerosum.out"));

        n = Integer.parseInt(in.readLine());
        in.close();

        solve(1, "", "", "");

        for (String s : set)
            out.println(s);
        out.close();

        if (debug) {
            System.out.println(n);
        }
    }

    static void solve(int k, String op, String ans, String str) {
        if (k > n) {
            int sum = 0;
            String lastOp = "+";
            for (int i = 0; i < ans.length(); i++) {
                if (ans.charAt(i) == '+') {
                    lastOp = "+";
                    continue;
                } else if (ans.charAt(i) == '-') {
                    lastOp = "-";
                    continue;
                }
                int sum2 = 0, j = i;
                while (j < ans.length() && Character.isDigit(ans.charAt(j))) {
                    sum2 *= 10;
                    sum2 += Character.getNumericValue(ans.charAt(j));
                    j++;
                }
                if (lastOp.equals("+")) {
                    sum += sum2;
                } else if (lastOp.equals("-")) {
                    sum -= sum2;
                }
                i = j - 1;
            }
            if (sum == 0)
                set.add(str);
            if (debug) {
                if (sum == 0) {
                    System.out.println(sum);
                    System.out.println(ans);
                    System.out.println(str);
                    System.out.println("______________");
                }
            }
            return;
        }
        if (!op.equals(" "))
            ans += op;
        ans += k;
        str += op;
        str += k;

        solve(k + 1, "+", ans, str);
        solve(k + 1, "-", ans, str);
        solve(k + 1, " ", ans, str);
    }
}
