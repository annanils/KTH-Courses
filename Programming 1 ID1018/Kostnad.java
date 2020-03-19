// Kostnad.java

//ett program som utför en enkel beräkning 


/**********************************************************************
 * 
 * Det här programmet beräknar kostnaden för ett antal likadana böcker.
 * Både antalet och pris på böckerna mats in från standardinmatnings-
 * enheten. Resultatet skrivs ut till standardutmaningsenheten. 
 * 
 * *******************************************************************/
 

public class Kostnad 
{	
	 public static void main (String[] args)
	 {
		 	System.out.println   ("KOSTNAD");
		 	System.out.println   ();
		 	
		 	// inmatningsverktyg
		    java.util.Scanner    in = new java.util.Scanner
(System.in);
		    in.useLocale   (java.util.Locale.US) ;
		    
		    // mata in uppgifter om antalet böcker och deras pris
		    System.out.print  ("Antalet bocker: ");
		    int    antal = in.nextInt  ();
		    System.out.print  ("Pris pa bockerna:   ");
		    float    pris = in.nextFloat () ;
		    
		    // beräkna den totala kostnaden 
		    float   kostnad = antal * pris; 
		    		
		   // visa resultatet
		   System.out.println ("Den totala kostnaden: " + kostnad);
	 }
}		 	
		 	
	 
/*----------------------------------------------------------------
 
Programmets input och output vid en exekvering

KOSTNAD 

Antalet bocker: 25
Pris pa bockerna: 50
Den totala kostnaden: 1250.0

	
Programmets input och output vid en annan exekvering

KOSTNAD

Antalet bocker: 47
Pris pa bockerna: 230
Den totala kostnaden: 10810.0

-------------------------------------------------------------------*/


