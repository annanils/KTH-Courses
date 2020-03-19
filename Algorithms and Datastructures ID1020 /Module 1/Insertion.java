import java.util.Iterator;
public class Insertion<Item> implements Iterable<Item> {

	private Node first;
	private Node last;

	public static void main(String[] args) {

		Insertion<Integer> node = new Insertion<>();
		
		node.insert(2);
		node.insert(3);
		node.insert(1);
		node.insert(8);
		node.insert(6);
		node.insert(2);
	
	}

	public void insert (int n) {
		
		if (first == null) {
			first = new Node(n, null);
			
			nodeIterator iterator = new nodeIterator();
		
			/*while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}*/
			System.out.println(this);
			System.out.println("\n");
				return;
			
		}
	

		Node temp = first;
		Node nextNode = first.next; // temp ligger alltid en före nextNode 
	
				if(temp.n > n) {
					Node newNode = new Node(n, temp);
					first = newNode;
					
					nodeIterator iterator = new nodeIterator();

					/*while (iterator.hasNext()) {
						System.out.println(iterator.next());
					}*/
					System.out.println(this);
					System.out.println("\n");
					
					return;
				}
				
			while(nextNode != null && n > nextNode.n) { //måste kolla om den är null FÖRST
				temp = temp.next;
				nextNode = nextNode.next; 
					
			}
			
			
				if(nextNode == null) {
					Node newNode = new Node(n, null);
					temp.next = newNode;
					
					nodeIterator iterator = new nodeIterator();

					/*while (iterator.hasNext()) {
						System.out.println(iterator.next());
					}*/
					System.out.println(this);
					System.out.println("\n");
					return;
						
					}
				else {
					Node newNode = new Node (n, nextNode);
					temp.next = newNode;
					nodeIterator iterator = new nodeIterator();

					/*while (iterator.hasNext()) {
						System.out.println(iterator.next());
					}*/
					System.out.println(this);
					System.out.println("\n");
					return;
				}
				
					
			}
	

	public Integer pop() {
		Node p = first; // sparat första (lokalt, i den här metoden)
		// System.out.println(first.n); samma sak som pop i main
		first = first.next; // poppar
		nodeIterator iterator = new nodeIterator();

		/*while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/
		System.out.println(this);
		System.out.println("\n");
		return p.n;

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

	private class Node {
		Node next;
		Integer n;

		public Node(int n, Node node) {// har en konstruktor som skapar objekt (värden kommer in)
			this.n = n;
			this.next = node;
		}

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

				return (Item) r.n;
			}

			return null;
		}
	}

	
}
