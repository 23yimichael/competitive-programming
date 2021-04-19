#include <bits/stdc++.h>
using namespace std;

int n;
string s;

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ":";
    cin >> n; cin >> s;
    cout << " " << 1;
    for(int i = 1; i < n; i++) {
      int cnt = 1;
      for(int j = i-1; j>=0; j--) {
        if(int(s[j])>=int(s[j+1])) break;
        cnt++;
      }
      cout << " " << cnt;
    }
    cout << "\n";
  }
}