/*
ID: 23yimic1
LANG: JAVA
PROG: pprime
*/

import java.util.*;
import java.io.*;

class pprime {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter out = new PrintWriter(new FileWriter("pprime.out"));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        TreeSet<Integer> ans = new TreeSet<>();
        if (a / 10 == 0) {
            for (int i = a; i <= 9; i++) {
                if (isPrime(i))
                    out.println(i);
            }
        }
        for (int i = 1; i <= 9999; i++) {
            int nDigits = Integer.toString(i).toCharArray().length;
            int n = (i * (int) Math.pow(10, nDigits)) + reverse(i);
            if (n >= a && n <= b) {
                if (isPrime(n))
                    ans.add(n);
            }
            for (int j = 0; j <= 9; j++) {
                n = ((i * (int) Math.pow(10, nDigits + 1)) + (j * (int) Math.pow(10, nDigits) + reverse(i)));
                if (n < a || n > b)
                    continue;
                if (isPrime(n))
                    ans.add(n);
            }
        }
        for (int v : ans)
            out.println(v);
        out.close();
    }

    static int reverse(int n) {
        int ret = 0;
        String str = Integer.toString(n);
        int nDigits = str.toCharArray().length;
        for (int i = str.length() - 1; i > -1; i--) {
            ret += (Character.getNumericValue(str.charAt(i)) * (int) Math.pow(10, nDigits - 1));
            nDigits--;
        }

        return ret;
    }

    static boolean isPrime(int n) {
        if (n % 2 == 0)
            return false;
        if (n == 2 || n == 3)
            return true;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
}
