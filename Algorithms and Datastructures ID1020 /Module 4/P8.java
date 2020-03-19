/* Written 2019-10-08 by Anna Nilsson

 * This code will find and print
 * a topological sort of the following small data base:
 * TA-TB, TA-TF, TC-TA, TD-TF, TF-TE, TG-TE, TH-TG, TI-TH, TJ-TK, TJ-TL, TJ-TM, TL-TM
 * and the output will be:
 * TJ
 * TK
 * TL
 * TM
 * TI
 * TH
 * TG
 * TD
 * TC
 * TA
 * TB
 * TF
 * TE
 */

public class P8 {

    public static void main(String[] args) {

        String filename = args[0];

        String delim = "-"; //skapar en kant genom ett mellanslag mellan noderna
        SymbolDigraph sdg = new SymbolDigraph(filename, delim);
        Topological topological = new Topological(sdg.digraph());


            for (int w : topological.order()) {
                System.out.println(sdg.nameOf(w));
            }

        }


}

