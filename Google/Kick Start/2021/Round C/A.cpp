#include <bits/stdc++.h>
using namespace std;

const int mod = 1e9+7;
int n, k;
string s;
const string alpha[] = {"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ": ";
    cin >> n >> k;
    cin >> s;
    int cnt = 0;
    if(n==1){
      cnt=int(s.at(0))-97;
    }
    cout << cnt%mod << "\n";
  }
}
