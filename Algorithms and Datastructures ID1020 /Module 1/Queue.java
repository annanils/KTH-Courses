import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

	public static void main(String[] args) {

		Queue<Integer> queue = new Queue<>();
		queue.push(2);
		queue.push(4);
		queue.push(3);
		queue.pop();
		queue.pop();
		queue.pop();
		queue.push(-1);
		
		//System.out.println(queue);

		// for(Integer r : queue) {
		// System.out.println(r);

		// }

	}

	java.util.Scanner in = new java.util.Scanner(System.in);

	private Node last; // håller koll på vem som är först och sist i kön
	private Node first;

	public Queue() {

	}
	// first byter plats när vi pushar, last byter plats när vi popar (tar bort den
	// som är längst bak)

	private class Node {
		Node next;
		Node prev;
		Item item;

		public Node(Item n) {// har en konstruktor som skapar objekt
			this.item = n;
			this.next = null; // lägger till en ny, "den förra sista"
		}
	}

	public String toString() {
		
		if(first == null && last == null) {
			return "\n"; 
		}

		Node n = first;
		StringBuilder str = new StringBuilder();
		while (n != null) {// andävnd inte first för att den ändrar pekaren. Kan inte hitta tillbaka till
							// första elementet
			str.append("[");
			str.append(n.item);
			str.append("], ");
			n = n.prev;

		}

		return str.toString();
	}

	public void push(Item n) { // push ställer sig längst bak i kön
		
		if(first == null && last == null) {
			Node newNode = new Node (n);
			first = newNode;
			last = newNode;
			System.out.println(this);

			return;
		}
		
		Node newNode2 = new Node(n);
		last.prev = newNode2;
		newNode2.next = last;
		last = newNode2; 
		System.out.println(this);
		
		/*Node old = last; // sparar det gamla värdet
		last = new Node(n, old); // fyller på med nya värden här
		last.next = old;
		if (old != null)
			old.prev = last;

		if (first == null) {
			first = last;
		}
		// first.n = n;
		// first.next = oldfirst;
		System.out.println(this);*/

	}

	public Item pop() {// pop kommer använda first
		
		
		if(first==last) {
			Node n = first; 
			first = null;
			last = null;
			System.out.println(this);

			return n.item; 
		}

		Node p = first; // sparat första (lokalt, i den här metoden)
		// System.out.println(first.n); samma sak som pop i main
		first = first.prev; // hoppar in i noden .prev pekar till. Alla länkar som går TILL noden vill man
							// ta bort(next)
		first.next = null; // first.next = pilen som pekar tillbaka
		
		
		System.out.println(this);
		return p.item; // vi vill ha innehållet i p efter vi poppat noden

	}

	@Override
	public Iterator<Item> iterator() {

		return new QueueIterator();
	}

	class QueueIterator implements Iterator<Item> {

		private Node head; // är till för att skapa iteratorn. bläddra igenom listan utan att göra några
							// ändringar

		public QueueIterator() {
			this.head = first;
		}

		public boolean hasNext() { // frågar "har den någon kvar", "finns det någon just nu?"
			if (head != null)
				return true;
			else {
				return false;
			}

		}

		@Override
		public Item next()/* enklare version av pop */ {
			if (hasNext() == true) {
				Node r = head;
				head = head.prev;

				return r.item;
			}

			return null;
		}

	}

}
