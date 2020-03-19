import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/* Written 2019-09-21 by Anna Nilsson 
 * 
 * This code will sort an array of various length in ascending order, 
 * with a sortingmethod called Insertionssort, and print an integer
 * of swaps that will occur. For example if the user set the arraylength to be 5
 * and the elements in the array to be [1, 3, 2, 4, 5], the output is 1, becuase
 * 1 swap must be done before the array is sorted. 
 * 
 */
public class Nrswaps {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);

		int antalElement = in.nextInt();
		int[] t = new int[antalElement];
		for (int i = 0; i < t.length; i++) {
			t[i] = in.nextInt();
		}
		sort(t);
		//System.out.println(Arrays.toString(t));
	}

	public static void sort(int[] a) {

		int count = 0;
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {

				exch(a, j, j - 1);
				count++;
				

				// for(int p = 0; p < a.length; p++)
				// System.out.print(a[p] + " ");
				// System.out.println();
			}
			

		}
		System.out.println();
		System.out.println(count);

		
	}

	public static boolean less(Integer v, Integer w) {
		return v.compareTo(w) < 0;
	}

	public static void exch(int[] a, int i, int j) {
		Integer t = a[i];a[i] = a[j];a[j] = t;
	}

}
