#include <stdio.h>

void reverse(){
    
char a[5]; 
char c = getchar();
int i = 0;

while ((5 >= i) && (c != '\n')){
    a[5 - i] = c;
    i++;
    c = getchar();
}

for(int i = 0; i <= 5; i++){
            printf("%c\n", a[i]);
        }
        printf("\n");

}

int main(){
    reverse();
}
    
    
