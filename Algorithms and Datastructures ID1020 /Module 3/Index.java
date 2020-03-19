/* Written 2019-09-30  
 * 
 * This code will lsit the position of all occurrences of X as answer to the query.
 * For instance is the input is: java Index sun <Thetext.txt, the output will be:
 * 
 * Ordet ligger på index: 5027
 * Ordet ligger på index: 5085
 * Ordet ligger på index: 5099
 * Ordet ligger på index: 22015
 * Ordet ligger på index: 28102
 * Ordet ligger på index: 30394
 * Ordet ligger på index: 32326
 * Ordet ligger på index: 40528
 * Ordet ligger på index: 40567
 * Ordet ligger på index: 40608
 * Ordet ligger på index: 45273
 * Ordet ligger på index: 45649
 * Ordet ligger på index: 45744
 * Ordet ligger på index: 53568
 * Ordet ligger på index: 55357
 * Ordet ligger på index: 55365
 * Ordet ligger på index: 55381
 * Ordet ligger på index: 60288
 * Ordet ligger på index: 60550
 * Ordet ligger på index: 60704
 * Ordet ligger på index: 62181
 * Ordet ligger på index: 62524
 * Ordet ligger på index: 67450
 * Ordet ligger på index: 67738
 * Ordet ligger på index: 71859
 * Ordet ligger på index: 77935
 * Ordet ligger på index: 81623
 * Ordet ligger på index: 83689
 * Ordet ligger på index: 83694
 * Ordet ligger på index: 84971
 * Ordet ligger på index: 96335
 * Ordet ligger på index: 96360
 * Ordet ligger på index: 100180
 * Ordet ligger på index: 115213
 * Ordet ligger på index: 115257
 * Ordet ligger på index: 115299
 * 
 * 
 */
public class Index {

	public static void main(String[] args) {
		
		String key = StdIn.readString();
		String key2 = args[0]; //allt från args kommer från StdIn
		int words = 0;
		
		while (!StdIn.isEmpty()) {
			
			words++; //räknar hur många ord vi har (index). På så sätt skrivs platsen ut där ordet ligger ut. 
			
			if(key.equals(key2))
					System.out.println(" Ordet ligger på index: " + words); //platsen 
					
			key = StdIn.readString();  //läser nästa ord från stdin (boken) 
			
		}
	}

}
