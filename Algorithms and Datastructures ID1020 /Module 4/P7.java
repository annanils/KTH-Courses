/* Written 2019-09-30 by Anna Nilsson
 * This code finds directed cycles in the graph
 * (if there are no such cycles you should add non-trivial edges to the graph to test your program)
 * For instance if input is:
 * a b
 * a bb
 * b c
 * b a
 * bb c
 * c d
 * e f
 * The output will be:
 * b a b
 *
 * or
 * a b
 * a bb
 * b c
 * bb c
 * c d
 * e f
 * The output will be:
 * "There is no cycle"
 *
 */
public class P7 {

    public static void main(String [] args){

        String filename = args[0];
        String delim = " "; //skapar en kant genom ett mellanslag mellan noderna

        SymbolDirectedGraph sg = new SymbolDirectedGraph(filename, delim); //använder en symbolgraph för att koppla strängar till integers. Class Graph använder Integer som argument när den skapar grafen.
        DirectedCycle p = new DirectedCycle(sg.graph());

        if(p.hasCycle()){
            for (int w : p.cycle()) {
                System.out.print(sg.nameOf(w) + " ");
            }

        }
        else{
            System.out.println("There is no cycle");
        }

    }
}
