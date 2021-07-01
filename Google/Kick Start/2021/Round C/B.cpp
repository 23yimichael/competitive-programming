#include <bits/stdc++.h>
using namespace std;

#define ll long long

ll g;

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ": ";
    cin >> g;
    ll cnt = 0;
    ll ps[g+1];
    memset(ps, 0, sizeof(ps));
    for(ll k = 1; k <= g; k++) {
        ps[k]=k+ps[k-1];
        if(ps[k]==g) cnt++;
    }
    ll sub = 0;
    for(ll k = 1; k <= g; k++) {
      sub=ps[k];
      for(ll i = k+1; i <= g; i++) {
        ps[i]-=sub;
        if(ps[i]==g) cnt++;
      }
    }
    // for(ll k = 1; k <= g; k++) {
    //   ll sum = 0;
    //   ll temp = k;
    //   while(1){
    //     if(sum==g){
    //       cnt++;
    //       break;
    //     } else if (sum > g) break;
    //     sum+=temp;
    //     temp++;
    //   }
    // }
    cout << cnt << "\n";
  }
}
