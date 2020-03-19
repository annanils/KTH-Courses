#include <stdio.h>
#include <ctype.h>

/*Written 2019-09-30 by Anna Nilsson 
 *
 * This code will take a input from StdIn and determine if that
 * character is non alpabetic, blank or a new row. The code will remove
 * all other characters. For instance if inout is 78tyfje 5453 €%&//%, the
 * output will be:
 *  tyfje
 * 
*/

int main ()
{
    char c = getchar(); 
    char x = 'X';

    while(c != EOF){
        if(isalpha(c) || c == '\n' || c == ' '){ 
         putchar(c);
        
        }

        else{
            putchar(' ');
        }
    
        c = getchar(); 

    } 

    return 0;
}