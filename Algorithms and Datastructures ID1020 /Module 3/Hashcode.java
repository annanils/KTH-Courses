import java.util.*;

/* Written 2019-09-30 by Anna Nilsaon
 * 
 * This code will show how evenly the built-in hash function for strings in java distributes
 * the hashes for the words found in the text.
 * 
 */

public class Hashcode extends Hashtable {

	public static void main(String[] args) {

		//String[] words = StdIn.readAllStrings(); //läser in alla ord till en stringarray
		int[] newArray = new int[97]; //ny array 97 positioner lång(primtal)
 
		BST<String, Integer> st = new BST<String, Integer>();
    	//int minlen = Integer.parseInt(args[0]); // key-length cutoff
        //int minlen = 4; 
        while (!StdIn.isEmpty()) { // Build symbol table and count frequencies.
            String word = StdIn.readString();
            //if (word.length() < minlen) continue; // Ignore short keys.
            if (!st.contains(word)) st.put(word, 1); //value är hur många ggr ordet förekommer i texten
            else st.put(word, st.get(word) + 1);
        }
		
		
		for (String s : st.keys()) { //for/each loop. väljer alla objekt av typen string. Hur många distinkta ord som hashar till samma index. 
			int hash = (s.hashCode() & 0x7fffffff) % 101; //hashCode omvandlar ordet till summan av univärdena % längden på array
			newArray[hash]++; //utökar värdet om man föröker lägga in värdet på ett index . kollar hur många ggr vi har försökr lägga in ordet. 
		}

			for (int i : newArray) //itererar genom alla värden i arrayen. T.ex på index 3skriver den ut 2, för att den har försökt sätta in där två ggr.
				System.out.println(i);//alla sifforna på hur många gånger man försökt lägga till på ett index
	}

}

