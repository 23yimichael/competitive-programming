import java.util.*;
import java.io.*;

class StuckInARut {
    static boolean debug = false;
    static BufferedReader in;
    static StringTokenizer st;
    static int n;
    static List<int[]> north = new ArrayList<>(), east = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            String direction = st.nextToken();
            if (direction.equals("N"))
                north.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i });
            else
                east.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i });
        }

        Collections.sort(north, (a, b) -> a[0] - b[0]);
        Collections.sort(east, (a, b) -> a[1] - b[1]);

        int[] stopped = new int[n];
        Arrays.fill(stopped, -1);

        for (int[] n : north) {
            if (stopped[n[2]] != -1)
                continue;
            for (int[] e : east) {
                if (stopped[e[2]] != -1)
                    continue;
                int nTime = e[1] - n[1];
                int eTime = n[0] - e[0];
                if (nTime > -1 && eTime > -1) {
                    if (nTime > eTime) {
                        stopped[n[2]] = e[2];
                        break;
                    } else if (eTime > nTime)
                        stopped[e[2]] = n[2];
                }
            }
        }

        int[] ans = new int[n];
        for (int v : stopped) {
            if (v == -1)
                continue;
            while (v != -1) {
                ans[v]++;
                v = stopped[v];
            }
        }

        for (int v : ans)
            System.out.println(v);

        if (debug) {
            System.out.println(n);
            System.out.println(north);
            System.out.println(east);
            System.out.println(Arrays.toString(stopped));
        }
    }
}
