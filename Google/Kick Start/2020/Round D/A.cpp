#include <bits/stdc++.h>
using namespace std;

int n, v[200000];

bool ok(int index) {
  if(index>0){
    int i = 0;
    while(i<index&&v[i]<v[index]) i++;
    if(i==index) return true;
  }
  return false;
}

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ": ";
    cin >> n;
    for(int i = 0; i < n; i++) cin >> v[i];
    int cnt = 0;
    for(int i = 0; i < n; i++) if(ok(i)&&(i==n-1||v[i]>v[i+1])) cnt++;
    cout << cnt << "\n";
  }
}
