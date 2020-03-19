import java.util.Iterator;


public class GeneralizedQueue<Item> implements Iterable<Item> {

	public static void main(String[] args) {

		GeneralizedQueue<Integer> node = new GeneralizedQueue<>();

		node.push(45);
		// node.push(61);
		node.push(3);
		// node.push(21);
		node.push(11);
		node.push(12);
		node.push(5);

		// node.removeKthNode();
		node.removeKthNode(1);
		node.removeKthNode(2);

		// node.push(5);
		// node.removeKthNode(3);
		// node.removeKthNode(2);

	}

	private Node first;
	private Node last;

	public GeneralizedQueue() {

	}

	private class Node {
		Node next;
		Item n;

		public Node(Item n, Node node) {// har en konstruktor som skapar objekt (värden kommer in)
			this.n = n;
			this.next = node;
		}
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(Item n) { // push ställer sig längst bak i kön

		Node old = first; // sparar det gamla värdet
		first = new Node(n, old); // fyller på med nya värden här
		// first.next= old;
		// Node oldfirst = first; //sparar det gamla värdet
		// first = new Node(n, oldfirst); //fyller på med nya värden här
		// first = first.next;

		nodeIterator iterator = new nodeIterator();

		/*while (iterator.hasNext()) {
			System.out.println(iterator.next());

		}*/
		System.out.println("\n");
		System.out.println(this);
		

	}

	public Item removeKthNode(int k) {
		if (k <= 0)
			throw new RuntimeException("Ogiltligt värde på k");
		if (first == null)
			return null;
		if (k == 1) {
			Node p = first;
			first = first.next;
			nodeIterator iterator = new nodeIterator();

			/*while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}*/
			System.out.println("\n");
			System.out.println(this);
			return p.n;
		}

		Node temp = first; // temp är lika med first
		Node out;

		for (int i = 1; i < k - 1; i++) { 
			if (temp.next == null) {
				return null;
			}
			temp = temp.next; //Traverserar igenom listan

		}
		out = temp.next; //out blir det sista noden perkar till
		temp.next = out.next; //

		nodeIterator iterator = new nodeIterator();

		/*while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/
		System.out.println("\n");
		System.out.println(this);
		

		return out.n;

	}

	public String toString() {

		if (first == null) {
			return null;
		}

		Node n = first;
		StringBuilder str = new StringBuilder();
		while (n != null) {// andävnd inte first för att den ändrar pekaren. Kan inte hitta tillbaka till
							// första elementet
			str.append("[");
			str.append(n.n);
			str.append("], ");
			n = n.next;

		}

		return str.toString();
	}


	@Override
	public Iterator<Item> iterator() {
		return new nodeIterator();
	}

	class nodeIterator implements Iterator<Item> {

		private Node head; // är till för att skapa iteratorn. bläddra igenom listan utan att göra några
							// ändringar

		public nodeIterator() {
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
				head = head.next;

				return r.n;
			}

			return null;
		}
	}

}
