/*
ID: 23yimic1
LANG: JAVA
PROG: sprime
*/

import java.util.*;
import java.io.*;

class sprime {
    static HashSet<Integer> dp = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter out = new PrintWriter(new FileWriter("sprime.out"));

        int n = Integer.parseInt(in.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        for (int i = 0; i < n - 1; i++) {
            TreeSet<Integer> set2 = new TreeSet<>();
            for (int v : set) {
                for (int j = 0; j <= 9; j++) {
                    int value = v * 10 + j;
                    if (dp.contains(value) || isPrime(value))
                        set2.add(value);
                }
            }
            set = set2;
        }
        for (int v : set)
            out.println(v);
        out.close();
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2 || n == 3) {
            dp.add(n);
            return true;
        }
        if (n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        dp.add(n);
        return true;
    }
}
