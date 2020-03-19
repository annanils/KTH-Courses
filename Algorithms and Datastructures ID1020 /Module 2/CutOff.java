import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

/* Written 2019-09-21 by Anna Nilsson
 * 
 * This code consists of two algorithms, Quicksort and Insertionsort. By
 * augment the Quicksort-algorithm with the Insertionsort-method for different cut-off values, 
 * the executiontime is in most of the tests positively affected.
 * 
 */

public class CutOff {

	
	public static void main(String[] args){

		Comparable[] sorting1 = new Comparable[10000];
		
		

		Random random1 = new Random(4); //bra för att göra två identiska arrayer. båda ska vara random
		
		
		for(int i = 0; i < sorting1.length; i++) {
			sorting1[i] = random1.nextInt();
			
		}
		
		long quickStart = System.nanoTime();
		sortwithQuicksort(sorting1);
		//try {Thread.sleep(1000);} catch (Exception e) {}
		long quickEnd = System.nanoTime();
				
		//System.out.println((mergeEnd - mergeStart) * 10e-4);
		
		System.out.println((quickEnd - quickStart) * 10e-7 + "ms");
		
		
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void Insertionsort(Comparable[] a, int lo, int hi) {
		for (int i = lo; i < (hi + 1); i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}

	public static void sortwithQuicksort(Comparable[] a) {
		// StdRandom.shuffle(a); // Eliminate dependence on input.
		// quicksort(a, 0, a.length - 1);
		int cutoff = 10;
		StdRandom.shuffle(a); // Eliminate dependence on input.
		System.out.println("Cutoff = " + cutoff);
		quicksort(a, 0, a.length - 1, cutoff);
		
	}

	private static void quicksort(Comparable[] a, int lo, int hi, int cutoff) {

		if (hi <= lo + cutoff) {
			//Insertionsort(a, lo, hi);
			return;
		}

		int j = partition(a, lo, hi);
		quicksort(a, lo, j - 1, cutoff);
		quicksort(a, j + 1, hi, cutoff);

	}

	private static int partition(Comparable[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
		int i = lo, j = hi + 1; // left and right scan indices
		Comparable v = a[lo]; // partitioning item
		while (true) { // Scan right, scan left, check for scan complete, and exchange.
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j])) //börja på sista index(första gången)
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j); // Put v = a[j] into position
		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi]. //allt till vänster om pivotpiont i denna partiotionen är mindre än pivot
	}

	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static boolean less(Comparable aux2, Comparable aux3) {
		return aux2.compareTo(aux3) < 0;
	}

}
