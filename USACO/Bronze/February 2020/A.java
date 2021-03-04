import java.io.*;
import java.util.*;

class triangles {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));

        int n = Integer.parseInt(f.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        int base = 0;
        int height = 0;
        int area = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((x[i] == x[j] || x[j] == x[k] || x[i] == x[k])
                            && (y[i] == y[j] || y[j] == y[k] || y[i] == y[k])) {
                        // find the base
                        if (y[i] == y[j])
                            base = Math.abs(x[i] - x[j]);

                        else if (y[j] == y[k])
                            base = Math.abs(x[j] - x[k]);

                        else if (y[i] == y[k])
                            base = Math.abs(x[i] - x[k]);

                        // find the height
                        if (x[i] == x[j])
                            height = Math.abs(y[i] - y[j]);

                        else if (x[j] == x[k])
                            height = Math.abs(y[j] - y[k]);

                        else if (x[i] == x[k])
                            height = Math.abs(y[i] - y[k]);

                        area = (base * height);
                        list.add(area);
                    }
                }
            }
        }

        int max = 0;

        for (Integer v : list) {
            if (v > max)
                max = v;
        }

        out.println(max);

        out.close();
    }
}
