#include <bits/stdc++.h>
using namespace std;

int n, x, a[100000];

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ":";
    cin >> n >> x;
    for(int i = 0; i < n; i++) cin >> a[i];
    queue<int> q;
    for(int i = 1; i<=n; i++) q.push(i);
    while(q.size()!=0) {
      int id = q.front()-1;
      cout << id << "\n";
      if(a[id]<=x) {
        cout << " " << q.front();
        q.pop();
      } else {
        a[id]-=x;
        q.pop();
        q.push(id);
      }
    }
    cout << "\n";
  }
}
