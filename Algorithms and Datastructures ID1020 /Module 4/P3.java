/*Written 2019-09-30 by Anna Nilsson

 * This code will assign unique weights to the edges (1,2,3...E) and write a program that can
 * find the shortest path between X and Y. It will then print the vertices traversed and the associated sum of
 * the weights of the path. For instance if the input is: filename, CA and FL the output will be:
 * AZ - CA (11)
 * AZ - NM (12)
 * CO - NM (19)
 * CO - OK (20)
 * AR - OK (8)
 * AR - MS (7)
 * AL - MS (3)
 * AL - FL (1)
 * CA - FL Total distance: 81.0
 */
public class P3 {
    public static void main(String[] args) {


        String filename = args[0];

        String delim = " "; //skapar en kant genom ett mellanslag mellan noderna
        SymbolGraphEdgeWeighted sg = new SymbolGraphEdgeWeighted(filename, delim); //använder en symbolgraph för att koppla strängar till integers. Class Graph använder Integer som argument när den skapar grafen.
        //System.out.println(sg.graph()); //skickar tillbaka edgewithtedgraph till graph

        String from = args[1];
        String to = args[2];

        DijkstraUndirectedSP ewg = new DijkstraUndirectedSP((sg.graph()), sg.indexOf(args[1])); //har skapat algoritmstrukturen som letar efter shortest path.

        int start = sg.indexOf(from);
        int end = sg.indexOf(to);

        for (Edge i : ewg.pathTo(sg.indexOf(args[2]))) { //pathTo ger en lista av alla noder i den kortaste vägen
            //StdOut.printf("%s - %s (%d)", sg.nameOf(i.either()),c, i.weight() )
            System.out.println(
                    sg.nameOf(i.either()) + " - " +
                            sg.nameOf(i.other(i.either())) + " (" +  (int) i.weight() + ")" //i är en typ Edge och där sparas weight
            );
        }
        System.out.println(args[1] +" - "+ args[2] + " Total distance: " +  ewg.distTo(end));
    }

}


