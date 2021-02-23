/*
ID: 23yimic1
LANG: JAVA
PROG: runround
*/

import java.util.*;
import java.io.*;

class runround {
    static boolean debug = false;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("runround.in"));
        PrintWriter out = new PrintWriter(new FileWriter("runround.out"));

        m = Integer.parseInt(in.readLine());

        int i = m + 1;
        while (!check(i))
            i++;

        out.println(i);
        out.close();

        if (debug) {
            System.out.println(m);
        }
    }

    static boolean check(int n) {
        int[] a = new int[9];
        int length = 0;
        while (n != 0) {
            a[length++] = n % 10;
            n /= 10;
        }
        int index = 0;
        for (int i = length - 1; i > -1; i--) {
            if (index < i) {
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
                index++;
            } else
                break;
        }
        int cur = 0;
        boolean[] usedDigit = new boolean[10];
        boolean[] usedIndex = new boolean[9];
        for (int i = 0; i < length; i++) {
            cur = (cur + a[cur]) % length;
            if (a[cur] == 0 || usedDigit[a[cur]] || usedIndex[cur])
                return false;
            usedDigit[a[cur]] = true;
            usedIndex[cur] = true;
        }
        return true;
    }
}
