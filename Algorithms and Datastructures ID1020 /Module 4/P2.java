/* Written by Anna Nilsson 2019-10-08

 * This code is the same as P1, but uses the algorithm BreadthFirstPaths instead. If the input is the filename, AL and CA
 * the output will be:
 * AL
 * TN
 * MO
 * OK
 * NM
 * AZ
 * CA
 */
public class P2 {
    public static void main(String[] args) {

        String filename = args[0];

        String delim = " "; //skapar en kant genom ett mellanslag mellan noderna

        SymbolGraph sg = new SymbolGraph(filename, delim); //använder en symbolgraph för att koppla strängar till integers. Class Graph använder Integer som argument när den skapar grafen.
        BreadthFirstPaths b = new BreadthFirstPaths(sg.graph(), sg.indexOf(args[1]));

        for (int w : b.pathTo(sg.indexOf(args[2]))) {
            System.out.println(sg.nameOf(w) + " ");

        }

    }
}
