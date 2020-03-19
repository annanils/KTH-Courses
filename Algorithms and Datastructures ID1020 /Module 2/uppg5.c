#include <stdio.h>
//Written 2019-09-21 by Anna Nilsson 
//
//This code will take an input array with both positive and negative integers
//and sort the array so that all the negative integers come before the positive integers. 
//For instance if input arraylength is 5 and the elements are [-2, -3, 5, 9, 4, 1, -1], the
//output will be -2 -3 -1 9 4 1 5. This code also contains thrre loop invariants that will occur
//after each loopcondition. 




void reverse_in_place(int *nrElements, int length){ //jag vill ha en pekare till ett värde

    
    int n = length; //storleken på arrayen
    int temp; 
    int i = 0;
    int j = n - 1;   
    while(i != j){
            if(nrElements[i] < 0)
            i++; //Invariant: alla värden till vänster med index mindre än i kommer att vara negativa
            else if (nrElements[j] >= 0)
            j--; //Invariant: all värden med index större en j är positiva 
            else{  //Invariant:inga av dom ovanför stämmer,. så detta är sant. 
            temp = nrElements[j]; //dom här två elementen nedan är osorterade. 
            nrElements[j] = nrElements[i]; // elementet på plats i läggs på plats j
            nrElements[i] = temp; // elementet på plats j läggs på plats i
            }

        }
}


int main (){

    int nrElements[] = {-2, -3, 5, 9, 4, 1, -1};

    //printf("%d", *(nrElements)); //värdet där pekaren pekar

    reverse_in_place(nrElements, 7);

    for( int i = 0; i < 7; i++){
        printf("%d ", nrElements[i]); 
    }
    
    return 0;
}