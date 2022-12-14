package main;

public class Pes {

    private int vek;
    private int vyska;
    private int sirka;

    public int getVek() {
        return vek * 7;
    }

    public void setVek(int vek) {
        if (vek < 0) {
            return;
        }
        this.vek = vek;
    }

    public int getVyska() {
        return vyska;
    }

    public void makeSound(){
        System.out.println("Haf haf");

    }
}
