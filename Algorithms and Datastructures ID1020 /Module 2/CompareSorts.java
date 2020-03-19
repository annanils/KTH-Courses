import java.util.Random;

/* Written 2019-09-21 by Anna Nilsson 
 * 
 * This code is an algorithm that will print the time 
 * it will take to sort an array with n numbers, with a
 * sortingmethod called Mergesort. The code will take an array 
 * with random numbers and a manually set length as an input and
 * output will show various times in milliseconds, that it takes to sort the array.  
 * 
 * 
 */
public class CompareSorts {

	public static void main(String[] args) {

		Comparable[] sorting1 = new Comparable[10000];
		//Comparable[] sorting2 = new Comparable[sorting1.length];

		Random random1 = new Random(4); // bra för att göra två identiska arrayer. båda ska vara random
		//Random random2 = new Random(4);

		for (int i = 0; i < sorting1.length; i++) {
			sorting1[i] = random1.nextInt();
			//sorting2[i] = random2.nextInt();

		}

		System.out.println("Tider för Mergesort: ");
		// System.out.println("Tider för Quicksort: ");
		// long quickStart = System.currentTimeMillis();
		// sortwithQuicksort(sorting2);
		// long quickEnd = System.currentTimeMillis();
		//show(sorting1);
		long mergeStart = System.nanoTime();
		sortwithMergesort(sorting1);
		long mergeEnd = System.nanoTime();
		//show(sorting1);

		System.out.println((mergeEnd - mergeStart) * 10e-7 + " ms");

	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static boolean less(Comparable aux2, Comparable aux3) {
		// om v > w, returnerar pos
		// om v < w, returnerar neg
		// om v == w, returnerar 0
		return aux2.compareTo(aux3) < 0;
	}
	

	//sorterar elementen som delats upp och sammanfogar dom
	public static void merge(Comparable[] a, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi]. lägger
																		// ihop dem-
		int i = lo, j = mid + 1;
		
		//sätter ihop 2 och 2
		for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
			aux[k] = a[k]; //kopierar över i extra arryen

		for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];

	}

	private static Comparable[] aux; //extra array för kopiering av element

	public static void sortwithMergesort(Comparable[] a) { // börjar sorteringen
		aux = new Comparable[a.length]; // Allocate space just once.
		mergesort(a, 0, a.length - 1);
	}
	//delar upp arrayen i subarrayer, tills det bara är ett element
	private static void mergesort(Comparable[] a, int lo, int hi) { // Sort a[lo..hi]. //delar upp dom
		//high= low, färdig, allt är uppdelat till bara 1 indexstora arrays, 
		//går förbi varandra om ojämnt antal
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		mergesort(a, lo, mid); // Sort left half. rekursivt, delar upp första halvan i 2 om och om igen
		mergesort(a, mid + 1, hi); // Sort right half. delar upp andra halvan i 2 om och om igen
		merge(a, lo, mid, hi); //metoden som sammanfogar och sorterar delarrayerna
	}

	/////////////////////////////////////////////
	////// QUICK SORT /////////
	/////////////////////////////////////////////

	/*
	 * public static void sortwithQuicksort(Comparable[] a) { StdRandom.shuffle(a);
	 * // Eliminate dependence on input. quicksort(a, 0, a.length - 1); } private
	 * static void quicksort(Comparable[] a, int lo, int hi) { if (hi <= lo) return;
	 * int j = partition(a, lo, hi); // Partition (see page 291). quicksort(a, lo,
	 * j-1); // Sort left part a[lo .. j-1]. quicksort(a, j+1, hi); // Sort right
	 * part a[j+1 .. hi]. }
	 * 
	 * private static int partition(Comparable[] a, int lo, int hi) { // Partition
	 * into a[lo..i-1], a[i], a[i+1..hi]. int i = lo, j = hi+1; // left and right
	 * scan indices Comparable v = a[lo]; // partitioning item while (true) { //
	 * Scan right, scan left, check for scan complete, and exchange. while
	 * (less(a[++i], v)) if (i == hi) break; while (less(v, a[--j])) if (j == lo)
	 * break; if (i >= j) break; exch(a, i, j); } exch(a, lo, j); // Put v = a[j]
	 * into position return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi]. } public
	 * static void exch(Comparable[] a, int i , int j) { Comparable t = a[i]; a[i] =
	 * a[j]; a[j] = t; }
	 */

}
