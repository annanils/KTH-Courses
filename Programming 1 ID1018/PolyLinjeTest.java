class PolylinjeTest{
    static private Punkt[] punkter;

    public static void main(String[] args) {
        punkter = new Punkt[5];
        punkter[0] = new Punkt("A", 3, 6);
        punkter[1] = new Punkt("B", 8, 2);
        punkter[2] = new Punkt("C", 6, 1);
        punkter[3] = new Punkt("D", 9, 2);
        punkter[4] = new Punkt("E", 4, 9);

        
        
        Polylinje linje1 = new Polylinje(punkter);
        Polylinje linje2 = new Polylinje();
        
        System.out.println(linje1);
        System.out.println(linje1.langd());
        
        linje1.laggTillFramfor(new Punkt("X", 4, 6), "C");
        System.out.println(linje1);
        
        linje1.taBort("E");
        System.out.println(linje1);

        String namn = linje1.getfarg();
        namn = "turkos";
        
        linje1.setBredd(3);
        linje1.setfarg("bla");
        System.out.println(linje1);
        
        Polylinje.PolylinjeIterator iterator = linje1.new PolylinjeIterator();
        System.out.println(iterator.finnsHorn());
        System.out.println(iterator.horn());
        iterator.gaFram();
        System.out.println(iterator.horn());
        iterator.gaFram();
        System.out.println(iterator.horn());
        iterator.gaFram();
        System.out.println(iterator.horn());
        
        while (iterator.finnsHorn()) {
            System.out.println(iterator.horn());
            iterator.gaFram();
        }
        

        
        Polylinje.PolylinjeIterator iterator2 = linje2.new PolylinjeIterator();
        System.out.println(iterator2.finnsHorn());

        System.out.println(linje2.langd());


        Window.xpoints = new int[punkter.length];
        Window.ypoints = new int[punkter.length];
        Window.points = punkter.length;
        for (int i = 0; i < punkter.length; i++) {
            Window.xpoints[i] = punkter[i].getX() * 50;
            Window.ypoints[i] = punkter[i].getY() * 50;
        }
        Window.start();
        Window.drawPolyline(linje1);
    }
    
}