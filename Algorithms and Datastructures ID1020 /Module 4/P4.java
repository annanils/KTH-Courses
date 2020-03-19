/*Written by Anna Nilsson 2019-10-08

 * This code computes a minimum spanning tree for the largest
 * connected component in the weighted graph from P3. For instance if the input is filename (Name of all US-states), then the
 * output will be:
 * AL - FL (1.00)
 * AL - GA (2.00)
 * AL - MS (3.00)
 * AL - TN (4.00)
 * AR - MS (7.00)
 * AR - LA (5.00)
 * AR - MO (6.00)
 * AR - OK (8.00)
 * AR - TX (10.00)
 * AZ - NM (12.00)
 * AZ - CA (11.00)
 * CO - NM (19.00)
 * AZ - NV (13.00)
 * AZ - UT (14.00)
 * CA - OR (16.00)
 * CO - OK (20.00)
 * CO - KS (17.00)
 * CO - NE (18.00)
 * CO - WY (22.00)
 * CT - NY (24.00)
 * CT - MA (23.00)
 * NJ - NY (91.00)
 * CT - RI (25.00)
 * DC - VA (27.00)
 * DC - MD (26.00)
 * KY - VA (60.00)
 * DE - MD (28.00)
 * DE - NJ (29.00)
 * DE - PA (30.00)
 * GA - NC (32.00)
 * GA - SC (33.00)
 * IA - MO (37.00)
 * IA - IL (35.00)
 * IA - MN (36.00)
 * IA - SD (39.00)
 * IA - WI (40.00)
 * ID - NV (42.00)
 * ID - MT (41.00)
 * ID - WA (45.00)
 * IL - IN (47.00)
 * IL - KY (48.00)
 * IN - MI (52.00)
 * IN - OH (53.00)
 * KY - WV (61.00)
 * MA - NH (64.00)
 * MA - VT (67.00)
 * ME - NH (71.00)
 * MN - ND (74.00)
 * Total distance: 1488.0
 * Another example:
 * If the input is:
 * a b
 * a bb
 * b c
 * bb c
 * c d
 * e f
 * The output will be:
 * a - b (1.00)
 * a - bb (2.00)
 * b - c (3.00)
 * c - d (5.00)
 * Total distance: 11.0
 *
 */
public class P4 {

    public static void main(String[] args) {

        String filename = args[0];

        String delim = " "; //skapar en kant genom ett mellanslag mellan noderna
        SymbolGraphEdgeWeighted sg = new SymbolGraphEdgeWeighted(filename, delim); //använder en symbolgraph för att koppla strängar till integers. Class Graph använder Integer som argument när den skapar grafen
        CC cc = new CC(sg.graph());
        //System.out.println(sg.graph());


        int largestIndex = 0;
        for (int i = 1; i < sg.size(); i++) {
            if (cc.size(largestIndex) < cc.size(i)) //vi sparar noden/hörnet som ligger i den största komponenten
                largestIndex = i;
        }

        int largestComponent = cc.id(largestIndex); //id:et på störtsta komponenten

        for(String nodeName : sg.keys) {
            int nodeIndex = sg.indexOf(nodeName);
            if(largestComponent != cc.id(nodeIndex)) {
                sg.deleteNode(sg.nameOf(nodeIndex));
            }
        }
        sg.build(filename, delim);

        //KruskalMST mst = new KruskalMST(sg.graph());
        PrimMST mst = new PrimMST(sg.graph());
        for (Edge i : mst.edges()) {
            //StdOut.println(i);
            StdOut.printf("%s - %s (%.2f)\n", sg.nameOf(i.either()), sg.nameOf(i.other(i.either())), i.weight());


        }


        System.out.println("Total distance: " + mst.weight());
        //System.out.println("Largest component has " + cc.size(sg.indexOf(args[0])));

    }
}
