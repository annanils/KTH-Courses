import java.util.Iterator;
import java.util.Scanner;

public class Filter implements Iterable<Character> {
	
	private Node first;
	private Node last;
	
	public static void main(String[] args) {

		Filter stack = new Filter();
		
		char c = StdIn.readChar();
		while(c != '\n'){
		stack.push(c);
		c = StdIn.readChar();
		}
		
		
		
		System.out.println("Balanced");
		
		
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	
	/*public boolean isBalanced (String s) { //högerparantes poppas, vänsterparantes pushas
		
		Filter stack = new Filter();
		
		if(s == '('|| s =='{'|| s == '[') {
			
		for(int i = 0; i < stack.length; i++) {
			
			
			
		}
			
			
			return true;
		}*/
	

		
	
	
	public void push(char n){
		if(n == '('|| n =='{'|| n == '[') {
			Node oldfirst = first; //sparar det gamla värdet
			first = new Node(n, oldfirst); //fyller på med nya värden här
	}
		if(n == ')'|| n == '}' || n == ']') {
			if(!pop(n)) {
				throw new RuntimeException ("Not balanced");
			}
				
				
		}

	//	first.n = n; 
	//	first.next = oldfirst; 
	}
		
		
	public boolean pop(char n){
		Node p = first; //sparat första (lokalt, i den här metoden)
	//System.out.println(first.n); samma sak som pop i main 
		if(first != null) {
			first = first.next;  //poppar
		}
		else {
			first = null;
		}
		if(n == ')' && p.n == '(') {
			return true;	
		}
		if(n == '}' && p.n == '{')
			return true;
		if(n == ']' && p.n == '[') {
			return true;
		}
		return false;
	
	


}
	private class Node {
		Node next;
		char n;

		public Node(char n, Node node) {// har en konstruktor som skapar objekt (värden kommer in)
			this.n = n;
			this.next = node;
		}
		
	}

	


	public Iterator<Character> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
	