/*
ID: 23yimic1
LANG: JAVA
PROG: milk3
*/

import java.util.*;
import java.io.*;

class milk3 {
    static int ca, cb, cc;
    static boolean[][][] visited;
    static TreeSet<Integer> ans = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter out = new PrintWriter(new FileWriter("milk3.out"));

        StringTokenizer st = new StringTokenizer(in.readLine());
        ca = Integer.parseInt(st.nextToken());
        cb = Integer.parseInt(st.nextToken());
        cc = Integer.parseInt(st.nextToken());
        visited = new boolean[ca + 1][cb + 1][cc + 1];

        solve(0, 0, cc);
        int i = 0;
        for (int v : ans) {
            if (i == 0) {
                out.print(v);
                i++;
            } else {
                out.print(" " + v);
                i++;
            }
        }
        out.println();
        out.close();
    }

    static void solve(int a, int b, int c) {
        if (visited[a][b][c])
            return;
        visited[a][b][c] = true;
        if (a == 0)
            ans.add(c);
        // a->b
        if (a + b > cb)
            solve(a + b - cb, cb, c);
        else
            solve(0, a + b, c);
        // a->c
        if (a + c > cc)
            solve(a + c - cc, b, cc);
        else
            solve(0, b, a + c);
        // b->a
        if (b + a > ca)
            solve(ca, b + a - ca, c);
        else
            solve(b + a, 0, c);
        // b->c
        if (b + c > cc)
            solve(a, b + c - cc, cc);
        else
            solve(a, 0, b + c);
        // c->a
        if (c + a > ca)
            solve(ca, b, c + a - ca);
        else
            solve(c + a, b, 0);
        // c->b
        if (c + b > cb)
            solve(a, cb, c + b - cb);
        else
            solve(a, c + b, 0);
    }
}
