/* Written 2019-09-30 by Anna Nilsson 
 * 
 * This code will take three integers, n and x, and a text as an input from StdIn and
 * as an output the n:th to the n+x:th most förekommande words will be shown. The
 * first integer show how long the words minst can be.
 * For instance if the input is n = 2 and n = 3, and the word must more than 1 integer long 
 * the output will be:
 * 
 * and 4921
 * of 4102
 * to 3601
 * a 2864
 * 
 * which in this case means the 2:nd and the 5:th most frequent word is shown and how mant time it
 * förekommer in the text. 
 * 
 */
public class Query extends BinarySearchST {

	public static void main(String[] args) { // values är osorterade, så vi kan inte bara ta ut någonting
		int minlen = Integer.parseInt(args[0]); // key-length cutoff
		int N = Integer.parseInt(args[1]); // key-length cutoff
		int x = Integer.parseInt(args[2]); // key-length cutoff

		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(); 

		while (!StdIn.isEmpty()) { // Build symbol table and count frequencies.
			String word = StdIn.readString();
			if (word.length() < minlen)
				continue; // Ignore short keys.
			if (!st.contains(word)) //lägger in alla ord i listan 
				st.put(word, 1);
			else
				st.put(word, st.get(word) + 1);
		}
		// Find a key with the highest frequency count. Key är ordet, och value är hur
		// många gånger det förekommer
		String max = "";

		st.put(max, 0);
		for (String word : st.keys()) // det som förekommer flest gånger
			if (st.get(word) > st.get(max))// är det här ordet större än det största?
				max = word;
		
		for (int i = 1; i < N; i++) { //börjar räkna på ett för att vi människor säger "det första ordet"
			st.delete(max); // tar bort ordet som förekommer flest gånger
			st.put(max, 0);
			for (String word : st.keys()) // det som förekommer flest gånger
				if (st.get(word) > st.get(max))// är det här ordet större än det största?
					max = word;
			{

			}
		}

		// x är längden på intervallet
		for (int i = N; i <= (N + x); i++) {
			System.out.println(max +  " "  + st.get(max)); // skriver ut "the" 
			st.delete(max);
			st.put(max, 0);
			for (String word : st.keys()) // det som förekommer flest gånger
				if (st.get(word) > st.get(max))// är det här ordet större än det största?
					max = word;

		}

	}

}
