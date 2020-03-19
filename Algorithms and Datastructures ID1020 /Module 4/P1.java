/* Written 2019-09-30 by Anna Nilsson
 *
 *
 * This code is based on DepthFirstPath which can answer questions of the type:
 * "Find the a path from X to Y". This results in a list of vertices traversed from X to Y if there is a path. For instance if the
 * input is: filename, AL and CA, the output will be:
 * AL
 * TN
 * VA
 * WV
 * PA
 * OH
 * MI
 * WI
 * MN
 * SD
 * WY
 * UT
 * NV
 * OR
 * CA
 */

public class P1 {
    public static void main(String[] args) {

            String filename = args[0];

            String delim = " "; //skapar en kant genom ett mellanslag mellan noderna

            SymbolGraph sg = new SymbolGraph(filename, delim); //använder en symbolgraph för att koppla strängar till integers. Class Graph använder Integer som argument när den skapar grafen.
            DepthFirstPaths p = new DepthFirstPaths(sg.graph(), sg.indexOf(args[1])); //tar in en graf och en int)

            for (int w : p.pathTo(sg.indexOf(args[2]))) { //jämför med argument 1
                System.out.println(sg.nameOf(w) + " ");

            }

    }
}

