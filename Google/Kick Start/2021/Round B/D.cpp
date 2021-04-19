#include <bits/stdc++.h>
using namespace std;

int n, q, l[10000-1], a[10000-1], c[10000], w[10000];
bool visited[10000];
vector<int> adj[10001], vect;

int solve() {
  int m = 0;
  for(int v : vect) m=min(v,m);
  for(int i = m; i > 0; i--) {
    int cnt = 0;
    for(int v : vect) {
      if(v%i==0) cnt++;
      if(cnt==vect.size()) return i;
    }
  }
  return 1;
}

int main() {  
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ":";
    cin >> n >> q;
    for(int i = 0; i < n-1; i++) {
      int x, y; cin >> x >> y >> l[i] >> a[i];
      adj[x].push_back(y);
      adj[y].push_back(x);
    }
    for(int i = 0; i < q; i++) {
      cin >> c[i] >> w[i];
      memset(visited, 0, sizeof(visited));
      //bfs
      queue<int> q;
      q.push(c[i]);
      while(!q.size()==0){
        int u = q.front();
        q.pop();
        if(w[i]>=l[u]) vect.push_back(a[u]);
        for(int v : adj[u]){
          if(!visited[u]) {
            visited[u]=1;
            q.push(v);
          }
        }
      }
      cout << " " << (vect.size()==0?0:solve());
    }
    cout << "\n";
  }
}