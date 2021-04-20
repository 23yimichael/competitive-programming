#include <bits/stdc++.h>
using namespace std;

int n, k, s;

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ": ";
    cin >> n >> k >> s;
    cout << min(n, k-s+n-s)+k << "\n";
  }
}
