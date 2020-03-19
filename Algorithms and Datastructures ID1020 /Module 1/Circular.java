import java.util.Iterator;

public class Circular<Item> implements Iterable<Item> {
    public static void main(String [] args){
        Circular<Integer> node = new Circular<>();

       // node.pushBackend();
        //node.pushBackend();
        //node.pushInfront();

        for(Integer r : node){      //for each Integer r in the node, execute the following block of code
            System.out.println(r);
        }

    }
        private Node first;
        private Node last;
        private int length = 0;

        public Circular(){
            this.last = first; //konstruktorn sätter sista noden att peka på first-noden, så att det blir en circulär lista
        }

        private Item popBackEnd(){
            Node p = first;         //första noden i listan
            Item n = last.n;        //ett item n i sista noden (den som skall returneras)
            length--;               //listan blir en nod kortare iom vi popar den sista noden

            while(p.next != last){   //går igenom listan
                p = p.next;          //inkrementerar så vi går framåt i listan
            }
            last = p;
            p.next = first;         // sista noden pekar till första noden, eftersom det är en cirkulär lista

            return n;
        }

        private void pushInfront(Item n) {
            if (first == null) { //Listan är tom
                Node p = new Node(n, null);
                first = p;
                last = p;
                //p.next =
            }
        }

        public class Node{
            Node next;
            Item n;

            public Node(Item n, Node node){
                this.n = n;
                this.next = node;
            }
        }








    public Iterator<Item> iterator() {
        return null;
    }
}
