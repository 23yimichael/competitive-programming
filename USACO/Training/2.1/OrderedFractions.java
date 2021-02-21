/*
ID: 23yimic1
LANG: JAVA
PROG: frac1
*/

import java.util.*;
import java.io.*;

class frac1 {
    static boolean debug = false;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter out = new PrintWriter(new FileWriter("frac1.out"));

        n = Integer.parseInt(in.readLine());
        TreeMap<Double, String> map = new TreeMap<>();
        for (int den = 0; den <= n; den++) {
            for (int num = 0; num <= den; num++) {
                if (num == 0 && den == 0)
                    continue;
                if (!map.containsKey((double) num / den))
                    map.put((double) num / den, num + "/" + den);
            }
        }
        for (double key : map.keySet())
            out.println(map.get(key));
        out.close();
    }
}
