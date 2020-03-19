import java.util.Random;

/* Written 2019-09-21 by Anna Nilsson 
 * 
 * This code is an algorithm that will print the time 
 * it will take to sort an array with n numbers, with a
 * sortingmethod called Quicksort. The code will take an array 
 * with random numbers and a manually set arraylength as an input and
 * output will show various times in milliseconds, that it takes to sort the array.  
 * 
 */

public class Quicksort {
	
	public static void main(String[] args){

		Comparable[] sorting1 = new Comparable[10000];
		//Comparable[] sorting2 = new Comparable[sorting1.length];
		

		Random random1 = new Random(4); //bra för att göra två identiska arrayer. båda ska vara random
		
		
		for(int i = 0; i < sorting1.length; i++) {
			sorting1[i] = random1.nextInt();
			//sorting2[i] = random2.nextInt();
			
		}
		
		
		
		//System.out.println("Tider för Quicksort: ");
		System.out.println("Tider för Quicksort: ");
		long quickStart = System.nanoTime();
		sortwithQuicksort(sorting1);
		//try {Thread.sleep(1000);} catch (Exception e) {}
		long quickEnd = System.nanoTime();
		
		
		
		//long mergeStart = System.currentTimeMillis();
		//sortwithQuicksort(sorting1);
		//long mergeEnd = System.currentTimeMillis();
		
		
		
		//System.out.println((mergeEnd - mergeStart) * 10e-4);
		
		System.out.println((quickEnd - quickStart) * 10e-7 + " ms");
		
		
	}
	private static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void sortwithQuicksort(Comparable[] a) {
		StdRandom.shuffle(a); // Eliminate dependence on input.
		quicksort(a, 0, a.length - 1);
	}

	private static void quicksort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi); // Partition (see page 291).
		quicksort(a, lo, j - 1); // Sort left part a[lo .. j-1].
		quicksort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
	}

	private static int partition(Comparable[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
		int i = lo, j = hi + 1; // left and right scan indices
		Comparable v = a[lo]; // partitioning item
		while (true) { // Scan right, scan left, check for scan complete, and exchange.
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j); // Put v = a[j] into position. 
		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
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
