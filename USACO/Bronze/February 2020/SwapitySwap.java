import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.util.*;

class swap {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int A1 = Integer.parseInt(st.nextToken());
        int A2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int B1 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());
        int[] ar = new int[n];
        int[] og = new int[n];
        int magic = 0;

        for (int i = 0; i < n; i++) {
            ar[i] = i + 1;
            og[i] = ar[i];
        }

        for (int i = 0; i < k; i++) {

            // step a
            int l = A2 - 1;
            for (int j = A1 - 1; j < l; j++) {
                if (j == l)
                    break;
                int temp = ar[j];
                ar[j] = ar[l];
                ar[l] = temp;
                l--;
            }
            // step b
            int m = B2 - 1;
            for (int j = B1 - 1; j < m; j++) {
                if (j == m)
                    break;
                int temp = ar[j];
                ar[j] = ar[m];
                ar[m] = temp;
                m--;
            }
        }

        for (Integer v : ar) {
            out.println(v);
        }

        out.close();
    }
}
