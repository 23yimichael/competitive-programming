import java.io.*;
import java.util.*;

class breedflip {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("breedflip.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));

        int n = Integer.parseInt(f.readLine());
        String A = f.readLine();
        String B = f.readLine();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i])
                list.add(i);
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) == 1)
                list.set(i, -1);
        }

        for (Integer v : list) {
            if (v >= 0)
                ans++;
        }

        out.println(ans);

        out.close();
    }
}
