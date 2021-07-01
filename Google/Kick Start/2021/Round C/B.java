import java.util.*;
import java.io.*;

class B {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int tc = 1; tc <= t; tc++) {
            System.out.print("Case #" + tc + ": ");
            long g = Long.parseLong(sc.nextLine());
            int cnt = 0;
            long size = g+1;
            int[] ps = new int[];
            for(int k = 1; k <= g; k++) {
                ps[k]=k+ps[k-1];
                if(ps[k]==g) cnt++;
            }
            int sub = 0;
            for(int k = 1; k <= g; k++) {
                sub=ps[k];
                for(int i = k+1; i <= g; i++) {
                    ps[i]-=sub;
                    if(ps[i]==g) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}