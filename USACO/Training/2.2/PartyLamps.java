/*
ID: 23yimic1
LANG: JAVA
PROG: lamps
*/

import java.util.*;
import java.io.*;

class lamps {
    static boolean debug = true;
    static int n, c;
    static int[] a = { 1, 1, 1, 1, 1, 1 };
    static List<Integer> on = new ArrayList<>(), off = new ArrayList<>();
    static TreeSet<String> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("lamps.in"));
        PrintWriter out = new PrintWriter(new FileWriter("lamps.out"));

        n = Integer.parseInt(in.readLine());
        c = Integer.parseInt(in.readLine());
        if (c > 4 && c % 2 == 0)
            c = 4;
        else if (c > 3 && c % 2 == 1)
            c = 3;
        StringTokenizer st = new StringTokenizer(in.readLine());
        while (true) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp == -1)
                break;
            on.add(temp);
        }
        st = new StringTokenizer(in.readLine());
        while (true) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp == -1)
                break;
            off.add(temp);
        }
        in.close();

        solve(0, 0, 0);

        if (set.isEmpty()) {
            out.println("IMPOSSIBLE");
        } else {
            for (String str : set) {
                out.print(str);
                out.println();
            }
        }
        out.close();
        if (debug) {
            System.out.println(set);
        }
    }

    static void solve(int k, int button, int from) {
        if (button == 1) {
            for (int i = 0; i < 6; i++) {
                if (a[i] == 0)
                    a[i] = 1;
                else
                    a[i] = 0;
            }
        } else if (button == 2) {
            for (int i = 1; i < 6; i += 2) {
                if (a[i] == 0)
                    a[i] = 1;
                else
                    a[i] = 0;
            }

        } else if (button == 3) {
            for (int i = 0; i < 6; i += 2) {
                if (a[i] == 0)
                    a[i] = 1;
                else
                    a[i] = 0;
            }
        } else if (button == 4) {
            if (a[0] == 0) {
                a[0] = 1;
            } else if (a[0] == 1) {
                a[0] = 0;
            }
            if (a[3] == 0) {
                a[3] = 1;
            } else if (a[3] == 1) {
                a[3] = 0;
            }
        }
        if (k == c) {
            for (int v : on)
                if (a[(v - 1) % 6] == 0)
                    return;
            for (int v : off)
                if (a[(v - 1) % 6] == 1)
                    return;
            String ans = "";
            for (int i = 0; i < n; i++)
                ans += a[i % 6];
            set.add(ans);
            ans = "";
            return;
        }
        if (from == 1) {
            solve(k + 1, 2, button);
            solve(k + 1, 3, button);
            solve(k + 1, 4, button);
        } else if (from == 2) {
            solve(k + 1, 1, button);
            solve(k + 1, 3, button);
            solve(k + 1, 4, button);
        } else if (from == 3) {
            solve(k + 1, 1, button);
            solve(k + 1, 2, button);
            solve(k + 1, 4, button);
        } else if (from == 4) {
            solve(k + 1, 1, button);
            solve(k + 1, 2, button);
            solve(k + 1, 3, button);
        } else {
            solve(k + 1, 1, button);
            solve(k + 1, 2, button);
            solve(k + 1, 3, button);
            solve(k + 1, 4, button);
        }
    }
}
