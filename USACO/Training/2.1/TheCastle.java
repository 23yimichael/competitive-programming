/*
ID: 23yimic1
LANG: JAVA
PROG: castle
*/

import java.util.*;
import java.io.*;

class castle {
    static int m, n, size, roomNumber, ans = 0, ans2 = Integer.MIN_VALUE, ans3 = Integer.MIN_VALUE;
    static String ans4;
    static int[][] ar, grid, rooms;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("castle.in"));
        PrintWriter out = new PrintWriter(new FileWriter("castle.out"));

        StringTokenizer st = new StringTokenizer(in.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        ar = new int[n][m];
        grid = new int[n][m];
        rooms = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++) {
                boolean[] used = new boolean[4];
                ar[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    ar[i][j] -= 2;
                    used[2] = true;
                    grid[i][j] += 1000;
                } else if (i == n - 1) {
                    ar[i][j] -= 8;
                    used[0] = true;
                    grid[i][j] += 10;
                }
                if (j == 0) {
                    ar[i][j]--;
                    used[3] = true;
                    grid[i][j]++;
                } else if (j == m - 1) {
                    ar[i][j] -= 4;
                    used[1] = true;
                    grid[i][j] += 100;
                }
                if (used[0] == false || used[1] == false || used[2] == false || used[3] == false) {
                    for (int k = 0; k < 4; k++) {
                        if (used[k])
                            continue;
                        int v;
                        if (k == 0)
                            v = 8;
                        else if (k == 1)
                            v = 4;
                        else if (k == 2)
                            v = 2;
                        else
                            v = 1;
                        if (ar[i][j] == v) {
                            // north
                            if (v == 2) {
                                ar[i][j] -= v;
                                used[k] = true;
                                grid[i][j] += 1000;
                            }
                            // east
                            else if (v == 4) {
                                ar[i][j] -= v;
                                used[k] = true;
                                grid[i][j] += 100;
                            }
                            // south
                            else if (v == 8) {
                                ar[i][j] -= v;
                                used[k] = true;
                                grid[i][j] += 10;
                            }
                            // west
                            else {
                                ar[i][j] -= v;
                                used[k] = true;
                                grid[i][j]++;
                            }
                        } else if (ar[i][j] > v) {
                            // north
                            if (v == 2) {
                                ar[i][j] -= v;
                                used[k] = true;
                                grid[i][j] += 1000;
                            }
                            // east
                            else if (v == 4) {
                                ar[i][j] -= v;
                                used[k] = true;
                                grid[i][j] += 100;
                            }
                            // south
                            else if (v == 8) {
                                ar[i][j] -= v;
                                used[k] = true;
                                grid[i][j] += 10;
                            }
                            // west
                            else {
                                ar[i][j] -= v;
                                used[k] = true;
                                grid[i][j]++;
                            }
                        } else
                            used[k] = true;
                    }
                }

            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    ans++;
                    size = 0;
                    roomNumber = ans;
                    solve(i, j);
                    map.put(roomNumber, size);
                    ans2 = Math.max(ans2, size);
                }
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i > -1; i--) {
                if (i != 0 && rooms[i][j] != rooms[i - 1][j]) {
                    if (map.get(rooms[i][j]) + map.get(rooms[i - 1][j]) > ans3) {
                        ans3 = map.get(rooms[i][j]) + map.get(rooms[i - 1][j]);
                        ans4 = (i + 1) + " " + (j + 1) + " N";
                    }
                }
                if (j != m - 1 && rooms[i][j] != rooms[i][j + 1]) {
                    if (map.get(rooms[i][j]) + map.get(rooms[i][j + 1]) > ans3) {
                        ans3 = map.get(rooms[i][j]) + map.get(rooms[i][j + 1]);
                        ans4 = (i + 1) + " " + (j + 1) + " E";
                    }
                }
            }
        }
        out.println(ans);
        out.println(ans2);
        out.println(ans3);
        out.println(ans4);
        out.close();
    }

    static void solve(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        size++;
        rooms[x][y] = roomNumber;
        String temp = Integer.toString(grid[x][y]);
        if (temp.length() == 4) {
            for (int i = 0; i < temp.length(); i++) {
                if (i == 0 && temp.charAt(i) == '0')
                    solve(x - 1, y);
                else if (i == 1 && temp.charAt(i) == '0')
                    solve(x, y + 1);
                else if (i == 2 && temp.charAt(i) == '0')
                    solve(x + 1, y);
                else if (i == 3 && temp.charAt(i) == '0')
                    solve(x, y - 1);
            }
        } else if (temp.length() == 3) {
            solve(x - 1, y);
            for (int i = 0; i < temp.length(); i++) {
                if (i == 0 && temp.charAt(i) == '0')
                    solve(x, y + 1);
                else if (i == 1 && temp.charAt(i) == '0')
                    solve(x + 1, y);
                else if (i == 2 && temp.charAt(i) == '0')
                    solve(x, y - 1);
            }
        } else if (temp.length() == 2) {
            solve(x - 1, y);
            solve(x, y + 1);
            for (int i = 0; i < temp.length(); i++) {
                if (i == 0 && temp.charAt(i) == '0')
                    solve(x + 1, y);
                else if (i == 1 && temp.charAt(i) == '0')
                    solve(x, y - 1);
            }
        } else {
            solve(x - 1, y);
            solve(x, y + 1);
            solve(x + 1, y);
            for (int i = 0; i < temp.length(); i++) {
                if (i == 0 && temp.charAt(i) == '0')
                    solve(x, y - 1);
            }
        }
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return x + " " + y;
    }
}
