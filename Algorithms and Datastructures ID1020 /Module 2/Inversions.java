import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/*/* Written 2019-09-21 by Anna Nilsson 
 * 
 * This code will count the number of inversions in the input array and
 * will print a list of all inversions that has to be done before the
 * array is sorted. The goal is that the array is going to be sorted in ascending order. 
 * The output will show an integer number that corresponds to
 * the number of inversions. The number tells us how far or close the array
 * is from being sorted. For exmaple if the input arraylength is 5 and the elements are
 * [1, 3, 2, 4, 5], the output will be:
 * 
 * [1,3][2,2]
 * Antal invensioner: 1
 * 
 * which means that at index 1 is element 3 and at index 2 is element 2 and 
 * these two form an inversion. 
 * 
 * 
 */


public class Inversions {
	public static void main (String[] args) {
		Scanner in = new Scanner (System.in);
		in.useLocale  (Locale.US);
		
		System.out.println("Antal element: ");
		int antalElement = in.nextInt () ;
		System.out.println("Element: ");
		int[]  t = new int[antalElement];
		for(int i = 0; i < t.length; i++) {
			t[i] = in.nextInt();
		}
		//sort(t);
		//System.out.println(Arrays.toString(t)); 
		printInversions(t);
}


	public static void sort(int[] a) {
		
		int N = a.length;
		for(int i = 1; i < N; i++) {
			for(int j = i; j > 0 && less(a[j], a[j-1]); j--){
				//System.out.println(a[i]);
				exch(a, j, j-1);
				
				for(int p = 0; p < a.length; p++)
				System.out.print(a[p] + " ");
				System.out.println();
				//System.out.print("bajs");
		}
			//System.out.println();
			
		}
		
		System.out.println();
	}
		
	public static boolean less(Integer v, Integer w) {
		return v.compareTo(w) < 0;
	}
	
	public static void exch(int[] a, int i , int j) {
		Integer t  = a[i]; a[i] = a[j]; a[j] = t;
	}
	
	public static void printInversions (int[] nrElements) {
		int count = 0;
		int n = nrElements.length;
		for(int i = 0; i < n; i++) {
			int min = i;
			for(int j = i +1; j < n; j++) {
				if(nrElements[min] > nrElements[j]) {
					System.out.print("[" + min + "," + nrElements[min] + "]");
					System.out.println("[" + j + "," + nrElements[j] + "]");
					count++; 
				}
			}
			
		}
		System.out.println("Antal invensioner: " + count);
	}
	

}
