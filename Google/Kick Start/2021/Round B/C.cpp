#include <bits/stdc++.h>
using namespace std;

int z;

bool ok(int n) {
  if (n % 2 == 0)
    return 0;
  if (n == 2 || n == 3)
    return 1;
  for (int i = 3; i * i <= n; i += 2)
    if (n % i == 0)
      return 0;
   return 1;
}

int gen(int a){
  int ret = a+=2;
  while(!ok(ret)) ret+=2;
  return ret;
}

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ": ";
    cin>>z;
    if(z==6) {
      cout << 6 << "\n";
      continue;
    }
    int a = 3, b, ans = 6;
    while(1){
      //generate b
      b = gen(a);
      if(a*b>z) break;
      ans = a * b;
      a = b;
    }
    cout << ans << "\n";
  }
}