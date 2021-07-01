#include <bits/stdc++.h>
using namespace std;

string s;

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ": ";
    cin >> s;
    string ans = ""; int dep1 = 0, dep2;
    for(int i = 0; i < s.length(); i++) {
      int dep2 = s[i]-'0';
      while(dep1<dep2){
        ans+='(';
        dep1++;
      }
      while(dep1>dep2){
        ans+=')';
        dep1--;
      }
      dep1=s[i]-'0';
      ans+=s[i];
    }
    while(dep2>0){
      ans+=')';
      dep2--;
    }
    cout << ans << "\n";
  }
}
