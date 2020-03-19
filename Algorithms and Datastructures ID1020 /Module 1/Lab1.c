#include <stdio.h>

void reverse()
{
char r = getchar();
if(r != '\n'){
reverse(); //skickar inte in någonting, utan alla karaktärer läses in i getchar(); 
}

putchar(r);

}
int main()

{
    reverse(); 
    
}
