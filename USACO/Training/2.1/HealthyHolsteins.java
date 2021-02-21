/*
ID: 23yimic1
LANG: JAVA
PROG: holstein
*/

import java.util.*;
import java.io.*;

class holstein {
    static boolean debug = false;
    static int v, g, ans = Integer.MAX_VALUE;
    static int[] a;
    static int[][] ar;
    static Stack<Integer> s = new Stack<>();
    static boolean[] used;
    static ArrayList<Stack<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter out = new PrintWriter(new FileWriter("holstein.out"));

        v = Integer.parseInt(in.readLine());
        a = new int[v];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < v; i++)
            a[i] = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(in.readLine());
        ar = new int[g][v];
        for (int i = 0; i < g; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < v; j++)
                ar[i][j] = Integer.parseInt(st.nextToken());
        }

        used = new boolean[g];
        solve(1);

        if (list.size() == 1) {
            out.print(ans + " ");
            for (int i = 0; i < list.get(0).size(); i++) {
                out.print(list.get(0).get(i));
                if (i != list.get(0).size() - 1)
                    out.print(" ");
            }
            out.println();
        } else {
            out.print(ans + " ");
            int minIndex = 0;
            int minSize = 0;
            for (int i = 0; i < list.size(); i++) {
                int size = 0;
                for (int value : list.get(i)) {
                    size += value;
                }
                if (size < minSize) {
                    size = minSize;
                    minIndex = i;
                }
            }
            for (int i = 0; i < list.get(minIndex).size(); i++) {
                out.print(list.get(minIndex).get(i));
                if (i != list.get(minIndex).size() - 1)
                    out.print(" ");
            }
            out.println();
        }
        if (debug) {
            System.out.println(v);
            System.out.println(Arrays.toString(a));
            System.out.println(g);
            for (int[] row : ar)
                System.out.println(Arrays.toString(row));
            for (Stack<Integer> stack : list) {
                System.out.println(stack);
            }
        }
        out.close();
    }

    static void solve(int n) {
        if (n == g + 1) {
            if (s.size() == 0) {
                return;
            }
            if (works(s)) {
                if (s.size() < ans) {
                    ans = s.size();
                    list.clear();
                }
                list.add((Stack<Integer>) s.clone());
            }
            return;
        } else {
            s.push(n);
            solve(n + 1);
            s.pop();
        }
        solve(n + 1);
    }

    static boolean works(Stack<Integer> s) {
        int[] sums = new int[a.length];
        for (int val : s) {
            for (int i = 0; i < ar[val - 1].length; i++) {
                sums[i] += ar[val - 1][i];
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (sums[i] < a[i])
                return false;
        }
        return true;
    }
}
