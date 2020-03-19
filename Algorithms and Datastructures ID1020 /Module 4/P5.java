/* Written 2019-10-08 by Anna Nilsson
 *
 * This code can answer if there is a path between any to vertices. For instance if the
 * input is: Labb4.txt AL CA the output is:
 * "There is no path between AL and CA."
 * or for example if the input is: Labb4.txt AL WV, the output will be:
 * AL TN VA WV
 */

public class P5 {


    public static void main(String[] args) {

        String filename = args[0];

        String delim = " "; //skapar en kant genom ett mellanslag mellan noderna

        SymbolDirectedGraph sg = new SymbolDirectedGraph(filename, delim); //använder en symbolgraph för att koppla strängar till integers. Class Graph använder Integer som argument när den skapar grafen.
        DepthFirstDirectedPaths p = new DepthFirstDirectedPaths(sg.graph(), sg.indexOf(args[1]));

        int to = sg.indexOf(args[2]);
        if(p.hasPathTo(sg.indexOf(args[2]))) {
            for (int w : p.pathTo(to)) {
                System.out.print(sg.nameOf(w) + " ");
            }

        }
        else {
            System.out.println("There is no path between " + args[1] + " and " + args[2] + ".");
        }
    }
}

