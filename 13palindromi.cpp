#include <cstdio>
#include <iostream>

int main()
{
	int c;
	int vali = 'Z' - 'A' + 1;
	long long t[vali];
	for(int i=0; i<vali; i++)
		t[i]=0L;
	while( true ) {
		c = std::getchar();
		if( c >= 'A' && c <= 'Z')
			t[c -'A']++;
		else
			break;
	}
	int pariton = -1;
	for(int i=0; i < vali; i++) {
		if(t[i]%2==1) {
			if( pariton == -1)
				pariton = i;
			else {
				std::cout << "NO SOLUTION\n";
				return 0;
			}
		}
	}
	for(int i=0; i<vali; i++) {
		if( pariton != i ) {		
			for(int j=0; j<t[i]/2; j++)
				std::cout << (char) ('A'+i);
		}		
	}
	if(pariton >= 0)
		for(int i=0; i<t[pariton];i++) 
			std::cout << (char) ('A'+pariton);
	
	for(int i=vali-1; i>=0; i--) {
	if( pariton != i ) {		
			for(int j=0; j<t[i]/2; j++)
				std::cout << (char) ('A'+i);
		}				
	}
	std::cout << "\n";
	return 0;
}
