// LIsää muutoksia
// Tässä muutoksia

#include <iostream>

int main() {
  long long n;
  std::cin >> n;
  
  long long keskiarvo = (n - 1) / 2 + 1;
  long long summa = n * keskiarvo;

  // Kokonaislukuaritmetiikan takia parillisilla luvuilla
  // jää viimeisin luku ottamatta muuten mukaan summaan
  if( n % 2 == 0)
    summa += (n/2);  

  std::cout << summa;

}
