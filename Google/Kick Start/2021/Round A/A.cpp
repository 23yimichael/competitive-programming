#include <bits/stdc++.h>
using namespace std;

int n, k;
string s;

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ": ";
    cin >> n >> k; cin >> s;
    int score = 0;
    for(int i = 1; i <= n/2; i++) score+=s[i-1]!=s[n-i];
    cout << abs(k-score) << "\n";
  }
}
