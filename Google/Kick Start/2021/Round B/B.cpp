#include <bits/stdc++.h>
using namespace std;

int n, a[100000];

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ": ";
    cin >> n;
    for(int i = 0; i < n; i++) cin >> a[i];
    int sa[n-1];
    for(int i = 0; i < n-1; i++) sa[i]=a[i]-a[i+1];
    int ans = 0;
    for(int i = 0; i < n-1; i++) {
      int cnt = 1;
      bool used = 0;
      for(int j = 0; j < n-1; j++){
        if(sa[j]==sa[i]) cnt++;
        else if(!used&&sa[j]!=sa[i]&&j<n-2&&abs(sa[j])==abs(sa[j+1])) {
          used=1;
          cnt+=2;
          j++;
        } else if(!used&&sa[j]!=sa[i]) {
          used=1;
          cnt++;
        }
      }
      ans = max(ans, cnt);
      if(ans==n) break;
    }
    cout << ans << "\n";
  }
}