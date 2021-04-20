#include <bits/stdc++.h>
using namespace std;

int n, a[200000];

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ": ";
    cin >> n;
    int d[n-1];
    for(int i = 0; i < n; i++) cin >> a[i];
    for(int i = 0; i < n-1; i++) d[i]=a[i]-a[i+1];
    int ans = 0;
    for(int i = 0; i < n-1; i++) {
      int cnt = 0;
      for(int j = i+1; j < n-1; j++) {
        if(d[i]==d[j]) cnt++;
        else break;
      }
      ans = max(ans, cnt);
    }
    cout << ans+2 << "\n";
  }
}
