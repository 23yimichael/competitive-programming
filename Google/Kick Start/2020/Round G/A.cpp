#include <bits/stdc++.h>
using namespace std;

string s;

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ": ";
    cin >> s;
    int cnt = 0;
    for(int i = 0; i < s.length()-3; i++) {
      if(s[i]=='K'&&s[i+1]=='I'&&s[i+2]=='C'&&s[i+3]=='K') {
        for(int j = i+3; j < s.length()-4; j++) {
          if(s[j]=='S'&&s[j+1]=='T'&&s[j+2]=='A'&&s[j+3]=='R'&&s[j+4]=='T') cnt++;
        }
      }
    }
    cout << cnt << "\n";
  }
}
