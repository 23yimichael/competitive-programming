import java.io.*;
import java.util.*;

class word {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("word.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
    
    StringTokenizer st = new StringTokenizer(f.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(f.readLine());

    int discharge = k;

    for (int i = 0; i < n; i++) {
      String word = st.nextToken();
      int length = word.length();
      if (discharge == k) {
        out.print(word);
        discharge -= length;
      }
      else if (discharge == 0 || length > discharge) {
        out.println();
        discharge = k;
        out.print(word);
        discharge -= length;
      }
      else if (length <= discharge) {
        out.print(" " + word);
        discharge -= length;
      }
    }

    out.close();
  }
}
