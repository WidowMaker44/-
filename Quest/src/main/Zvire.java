package main;

public class Zvire {

    private int vek;
    private int vyska;
    private int sirka;

    public int getVek() {
        return vek * 7;
    }

    public void setVek(int vek) {
        if (vek < 0){
            return;
        }
        this.vek = vek;
    }

    public int getVyska(){
        return vyska;
    }
}
