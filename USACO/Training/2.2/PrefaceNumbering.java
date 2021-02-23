/*
ID: 23yimic1
LANG: JAVA
PROG: preface
*/

import java.util.*;
import java.io.*;

class preface {
    static boolean debug = false;
    static int n;
    static String[] a = { "I", "V", "X", "L", "C", "D", "M" },
            ar = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
    static ArrayList<Integer> list = new ArrayList<>();
    static HashMap<Integer, String> map = new HashMap<>();
    static HashMap<String, Integer> ans = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("preface.in"));
        PrintWriter out = new PrintWriter(new FileWriter("preface.out"));

        n = Integer.parseInt(in.readLine());
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        for (int i = 1; i <= n; i++) {
            int temp = i;
            int multiplier = 1;
            while (temp != 0) {
                int digit = temp % 10;
                if (digit == 0) {
                    temp /= 10;
                    multiplier *= 10;
                    continue;
                }
                String[] ref = new String[4];
                if (multiplier == 1000) {
                    ans.put("M", ans.getOrDefault("M", 0) + digit);
                    break;
                } else if (multiplier == 1) {
                    ref[0] = "";
                    ref[1] = "I";
                    ref[2] = "V";
                    ref[3] = "X";
                } else if (multiplier == 10) {
                    ref[0] = "";
                    ref[1] = "X";
                    ref[2] = "L";
                    ref[3] = "C";
                } else if (multiplier == 100) {
                    ref[0] = "";
                    ref[1] = "C";
                    ref[2] = "D";
                    ref[3] = "M";
                }
                String base = ar[digit];
                for (int j = 1; j <= base.length(); j++) {
                    char current = base.charAt(j - 1);
                    if (current == a[0].charAt(0)) {
                        ans.put(ref[1], ans.getOrDefault(ref[1], 0) + 1);
                    } else if (current == a[1].charAt(0)) {
                        ans.put(ref[2], ans.getOrDefault(ref[2], 0) + 1);
                    } else if (current == a[2].charAt(0)) {
                        ans.put(ref[3], ans.getOrDefault(ref[3], 0) + 1);
                    }
                }
                temp /= 10;
                multiplier *= 10;
            }
        }

        for (String key : a) {
            if (ans.containsKey(key)) {
                int value = ans.get(key);
                out.println(key + " " + value);
            }

        }
        out.close();

        if (debug) {
            System.out.println(ans);
        }
    }
}
