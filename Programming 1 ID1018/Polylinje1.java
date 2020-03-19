public class Polylinje1 {
    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    public Polylinje() {
        this.horn = new Punkt[0];
    }

    public Polylinje(Punkt[] horn) {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++)
            this.horn[i] = horn[i];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Punkt punkt : this.horn) {
            sb.append(punkt.toString());
        }
        sb.append("] " + this.farg + ", " + this.bredd);
        return sb.toString();
    }

    public Punkt[] getHorn() {
        Punkt[] punkter = new Punkt[this.horn.length];
        for (int i = 0; i < this.horn.length; i++) {
            punkter[i] = new Punkt(this.horn[i]);
        }
        return punkter;
    }

    public String getfarg() {
        return this.farg;
    }

    public int getBredd() {
        return this.bredd;
    }

    public void setfarg(String farg) {
        this.farg = farg;
    }

    public void setBredd(int bredd) {
        this.bredd = bredd;
    }

    public double langd() {
        double length = 0;
        for (int i = 1; i < this.horn.length; i++) {
            length += this.horn[i].avstand(this.horn[i - 1]);
        }
        return length;
    }

    public void laggTill(Punkt horn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = horn;
        this.horn = h;
    }

    public void laggTillFramfor(Punkt horn, String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int offset = 0;
        for (int i = 0; i < this.horn.length; i++) {
            if (!this.horn[i].getNamn().equals(hornNamn)){    
                h[i + offset] = this.horn[i];
            }
            else{   
                h[i] = horn;
                h[i + 1] = this.horn[i];
                offset = 1;      
            }
        }
        this.horn = h;
    }

    public void taBort(String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length - 1];
        int offset = 0;
        for (int i = 0; i < this.horn.length; i++) {
            if (!this.horn[i].getNamn().equals(hornNamn)){    
                h[i + offset] = this.horn[i];
            }
            else{   
                offset = -1;
            }
        }
        this.horn = h;
    }
}